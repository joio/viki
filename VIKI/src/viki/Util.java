package viki;

public class Util
{
    public static String replace(String s, String[] ts, String rep)
    {
	for(String t : ts)
	    s = s.replace(t, rep);
	return s;
    }
}
