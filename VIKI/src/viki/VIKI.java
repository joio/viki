/*
 * To change this template, choose Tools "},{" Templates
 * and open the template in the editor.
 */

package viki;

import java.net.*;
import java.io.*;

/**
 *
 * @author wannersi
 */
public class VIKI
{
    public String evaluateGerman(String sentence)
    {
       // sentence = sentence.toLowerCase();
        if(sentence.startsWith("Was ist "))
        {
            String q = sentence.substring(8, sentence.length() - 1);
            q = Util.replace(" " + q, new String[]{" ein "," eine "," der "," die "," das ","?"}, "");
            return getWiki(q);
        }else
            return null;
    }

    public String getWiki(String url)
    {
	System.err.println("wiki: " + url);
        String r = "";
        try{
        HttpURLConnection conn = (HttpURLConnection)new URL("http://de.wikipedia.org/w/index.php?title=" + url + "&printable=yes").openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = reader.readLine()) != null)
            r += line;
        int p = r.indexOf("<p>") + 3;
        int endP = r.indexOf("</p>", p);
        //System.out.println(r);
        r = r.substring(p, endP);
        }catch(IOException e)
        {
           // System.out.println(e.getMessage());
            return r;
        }
        return r;
    }
    
    
}
