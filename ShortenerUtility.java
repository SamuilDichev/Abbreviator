/*
 * Name: Samuil Dichev
 * Student number: c1340032
 */

public class ShortenerUtility {
	public static void main(String[] args) {
		if (args.length == 1) {														// I used If loops for a very specific reason.
			Shortener shrt = new Shortener();						 				// Read Past Attempts\Past Attempt 1\ShortenerUtility.java for that reason
			String output = shrt.shortenMessage(args[0]);
			System.out.println();					
			System.out.println("Shortened message: " + output);
		}

		else if (args.length > 1) {
			Shortener shrt = new Shortener(args[1]);							
			String output = shrt.shortenMessage(args[0]);
			System.out.println();					
			System.out.println("Shortened message: " + output);	
		}

		else if (args.length == 0) {
			System.out.println();
			System.out.println("Use instructions: ");
			System.out.println("1. The first argument is the message you'd like to shorten. Surround it in \"\"");	
			System.out.println("2. The second argument is the path/pathfile to the abbreviations file. Leave it blank for default file.");		
		}				
	}
}