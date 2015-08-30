/*
 * Name: Samuil Dichev
 * Student number: c1340032
 */

import java.io.File;

public class Evaluator extends Shortener {
    public Evaluator() {
        super();
    }

    public Evaluator( File inAbbreviationsFile ) {
        super(inAbbreviationsFile);
    }
    
    public Evaluator( String inAbbreviationsFilePath ) {
       super(inAbbreviationsFilePath);
    }
    
    public String evaluateMessage( String inMessage ) {
        super.shortenMessage(inMessage);
        
        int inputLength = inMessage.length();
        int outputLength = text.length()-1;
        int numberWords = inputParts.length;
        float shortenedPercent = 100-((float)outputLength/inputLength)*100;

        System.out.println();
        System.out.println("Length of input: " + inputLength);
        System.out.println();
        System.out.println("Number of words: " + numberWords);
        System.out.println();
        System.out.println("Length of output: " + outputLength);
        System.out.println();
        System.out.printf("Shortened by %.2f",shortenedPercent);
        System.out.println("%");
        return text;
    }
}