package viki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        VIKI viki = new VIKI();
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            System.out.println("Frage: " + line);
            String resp = viki.evaluateGerman(line);
            System.out.println("Antwort: " + (resp == null ? "Keine Ahnung!" : resp));
        }
    }

}
