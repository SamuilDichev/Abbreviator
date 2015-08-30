/*
 * Name: Samuil Dichev
 * Student number: c1340032
 * NOT AN OFFICIAL SUBMISSION! THIS IS A PAST ATTEMPT! Use only to gain better understanding of my choices!
 */

public class EvaluatorUtility {
    public static void main(String[] args) {
		if (args.length == 1) {														// I used If loops for a very specific reason.
			Evaluator eval = new Evaluator();						 				// Read Alternative/ShortenerUtility.java for that reason
			String output = eval.evaluateMessage(args[0]);
			System.out.println();					
			System.out.println("Output: " + output);
		}

		else if (args.length > 1) {
			Evaluator eval = new Evaluator(args[1]);							
			String output = eval.evaluateMessage(args[0]);				
			System.out.println("Output: " + output);	
		}

		else if (args.length == 0) {
			System.out.println();
			System.out.println("Use instructions: ");
			System.out.println("1. The first argument is the message you'd like to shorten. Surround it in \"\"");	
			System.out.println("2. The second argument is the path/pathfile to the abbreviations file. Leave it blank for default file.");		
		}				
	}
}