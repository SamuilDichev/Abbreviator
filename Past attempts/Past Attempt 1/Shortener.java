/*
 * Name: Samuil Dichev
 * Student number: c1340032
 * NOT AN OFFICIAL SUBMISSION! THIS IS A PAST ATTEMPT! Use only to gain better understanding of my choices!
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Shortener {

    private File abbsFile;
    private Scanner in;
    private Hashtable<String, String> abbsTable;
    private String fullWord;
    private String shortWord;
    private String punctuation;
    private String shortPunctuated;
    public String text = "";
    public String[] inputParts;
    
    //Constructor for default file!
    public Shortener() {
        try {
            abbsFile = new File("abbreviations.txt");
            in = new Scanner(abbsFile);
            abbsTable = new Hashtable<String, String>();

            while (in.hasNextLine()) {                          // Very similar to how we built the phonebook. 
                String line = in.nextLine();                    // I could save space and put this piece of code in shortenMessage, rather than
                String[] abbsParts = line.split(",");           // having it one time in each constructor. (I've done so in my past attempts) 
                String fullWord = abbsParts[0];                 // However, since this technically constructs a table,
                String shortWord = abbsParts[1];                // I chose to put it in the constructor. It just makes more sense.
                abbsTable.put(fullWord, shortWord);             // For more info check out Past attempts\Past Attempt 2\Shortener.java
            }
            in.close();
        }

        catch (FileNotFoundException ex) {
            System.out.println ("Abbreviations file not found!");
        }
    }

    //Constructor for an alternative file!
    public Shortener( File inAbbreviationsFile ) {
        try {
            in = new Scanner(inAbbreviationsFile);
            abbsTable = new Hashtable<String, String>();

            while (in.hasNextLine()) {                                          
                String line = in.nextLine();
                String[] abbsParts = line.split(",");
                String fullWord = abbsParts[0];                           
                String shortWord = abbsParts[1];
                abbsTable.put(fullWord, shortWord);                               
            }
            in.close();
        }

        catch (FileNotFoundException ex) {
            System.out.println ("Abbreviations file not found!");
        }
    }
    
    //Constructor for a file path!
    public Shortener( String inAbbreviationsFilePath ) {
        try {
            abbsFile = new File(inAbbreviationsFilePath);
            in = new Scanner(abbsFile);
            abbsTable = new Hashtable<String, String>();
            
            while (in.hasNextLine()) {                                        
                String line = in.nextLine();
                String[] abbsParts = line.split(",");
                String fullWord = abbsParts[0];                           
                String shortWord = abbsParts[1];
                abbsTable.put(fullWord, shortWord);                               
            }
            in.close();
        }

        catch (FileNotFoundException ex) {
            System.out.println ("Abbreviations file not found or incorrect file path!");
        }
    }
    
    //Shorten a single word!
    public String shortenWord( String inWord ) {
        if (inWord.endsWith("?")) {
            inWord = inWord.replaceAll("\\?","");
            punctuation = "?";
        }
        else if (inWord.endsWith(",")) {
            inWord = inWord.replaceAll("\\,","");
            punctuation = ",";
        }
        else if (inWord.endsWith(".")) {
            inWord = inWord.replaceAll("\\.","");
            punctuation = ".";
        }
        else if (inWord.endsWith("!")) {
            inWord = inWord.replaceAll("\\!","");
            punctuation = "!";
        }
        else if (inWord.endsWith(";")) {
            inWord = inWord.replaceAll("\\;","");
            punctuation = ";";
        }
        else {
            punctuation = "";
        }

        String abb = abbsTable.get(inWord);
        if (abb != null) {
            shortPunctuated = abb += punctuation;
            return shortPunctuated;
        }                             
        return inWord += punctuation;
    }
    
    //Shorten an entire message!
    public String shortenMessage( String inMessage ) {
        inputParts = inMessage.split("\\s+");
    
        for (int i = 0; i < inputParts.length; i++) {
            String x = inputParts[i];
            shortPunctuated = shortenWord(x) + " ";
            text += shortPunctuated;
        }
        return text;
    }
}