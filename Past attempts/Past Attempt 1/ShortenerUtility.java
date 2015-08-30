/*
 * Name: Samuil Dichev
 * Student number: c1340032
 * NOT AN OFFICIAL SUBMISSION! THIS IS A PAST ATTEMPT! Use only to gain better understanding of my choices!
 */

public class ShortenerUtility {
    public static void main(String[] args) {
    	try {
    		Shortener shrt = new Shortener(args[1]);					// Passing the args[0] as message! args[1] as a file (Or file path) 
	        String output = shrt.shortenMessage(args[0]);				// Couldn't figure out how to leave args[1] blank without an exception being thrown!
	        System.out.println("Shortened message: " + output);					
	    }

	    catch (ArrayIndexOutOfBoundsException ex) {						// Had to do this, because it gives me an exception
	        Shortener shrt = new Shortener();							// when I don't give it a second argument and fails to work. No clue why!
	        String output = shrt.shortenMessage(args[0]);				// Please address this in your feedback!
	        System.out.println("Shortened message: " + output);			
	    }
    }
}

// In the end, I didn't go with this because it's not an efficient solution.
// Also, sometimes the "catch" itself produces an exception, which I have no clue how to handle