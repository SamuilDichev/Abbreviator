/*
 * Name: Samuil Dichev
 * Student number: c1340032
 */

import java.io.Console;

public class EvaluatorUtility {
    public static void main(String[] args) {
    	if (args.length == 0) {	
	        Console console = System.console();
	        Evaluator eval = new Evaluator();
	        String input = console.readLine("Enter a message: ");
	        String output = eval.evaluateMessage(input);
	        console.printf("Output: " + output);
	    }

    	else if (args.length >= 1) {	
	        Console console = System.console();
	        Evaluator eval = new Evaluator(args[0]);
	        String input = console.readLine("Enter a message: ");
	        String output = eval.evaluateMessage(input);
	        console.printf("Output: " + output);
	    }
    }
}