/*
 * Name: Samuil Dichev
 * Student number: c1340032
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Shortener {

    private File abbsFile;
    private Scanner in;
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
        }

        catch (FileNotFoundException ex) {
            System.out.println ("Abbreviations file not found!");
        }
    }

    //Constructor for an alternative file!
    public Shortener( File inAbbreviationsFile ) {
        try {
            in = new Scanner(inAbbreviationsFile);
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

        while (in.hasNextLine()) {                                  // Very similar to how we built the phonebook. 
            String line = in.nextLine();                            // I forgot that scanner continue reading from the last line
            String[] abbsParts = line.split(",");                   // Which means that for every next word, it won't read the lines it has already read
            String fullWord = abbsParts[0];                         // I have solved this problem using a Hashtable. I also put the code which   
            String shortWord = abbsParts[1];                        // splits the lines in two parts in each constructor. It makes more sense to be there      
            if (inWord.equalsIgnoreCase(fullWord)) {                // even if it takes a bit more space due to the fact that there are 3 constructors
                shortPunctuated = shortWord += punctuation;         
                return shortPunctuated;
            }  
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