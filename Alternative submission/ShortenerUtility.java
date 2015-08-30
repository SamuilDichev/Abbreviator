/*
 * Name: Samuil Dichev
 * Student number: c1340032
 */
import java.io.Console;

public class ShortenerUtility {
    public static void main(String[] args) {
    	if (args.length == 0) {	
	        Console console = System.console();
	        Shortener shrt = new Shortener();
	        String input = console.readLine("Enter a message: ");
	        String output = shrt.shortenMessage(input);
	        console.printf(output);
	    }

    	else if (args.length >= 1) {	
	        Console console = System.console();
	        Shortener shrt = new Shortener(args[0]);
	        String input = console.readLine("Enter a message: ");
	        String output = shrt.shortenMessage(input);
	        console.printf(output);
	    }
    }
}