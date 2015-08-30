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
        
        int inputLength = inMessage.length();                                   // I made these variables mostly because I wanted to somehow
        int outputLength = text.length()-1;                                     // pass them to the EvaluatorUtility, so I can modify the output there, rather than here.
        int numberWords = inputParts.length;                                    // That way as long as the program works, there will be no need to edit the evaluator.
        float shortenedPercent = 100-((float)outputLength/inputLength)*100;     // The output would be able to be easily changed through EvaluatorUtility (hence the name Utility)
                                                                                // Unfortunately, I had only two days for this assessment due to another coursework
        System.out.println();                                                   // so I'll just leave it as it is
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