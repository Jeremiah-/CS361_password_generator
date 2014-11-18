import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Passwords {


	public static void main(String args[]) {

		if (args.length < 3) {
			System.out.println("Error: not enough arguments given. Format should be \'Passwords reference-Filename N k\'");
			return;
		} else if (args.length > 3) {
			System.out.println("Error: too many arguments given. Format should be \'Passwords reference-Filename N k\'");
			return;
		}

		String referenceTextFileName = args[0];

		// the number of passwords to generate
		String n = args[1];

		// the length of the passwords
		String k = args[2];

		File referenceTextFile;

		try {
			referenceTextFile = new File(referenceTextFileName);
		} catch (NullPointerException e) {
			System.out.println("Error: file name given is null.");
			return;
		}

		int[][] followers = new int[26][26];
		int[] counts = new int[26];
		int[] starters = new int[26];

		Scanner fileReader;

		try {
			fileReader = new Scanner(referenceTextFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: file name given was not found.");
			return;
		}

		while (fileReader.hasNext()) {
			String word = fileReader.next().toLowerCase();
			boolean isStartOfWord = true;
			// treat '-' as two seperate words. other characters just ignore and treat as one word.
			for (int i = 0; i < word.length(); i++) {
				int letterASCIIVal = word.charAt(i) - 97;
				int previousLetterVal;

				if (letterASCIIVal > 0 && letterASCIIVal < 26 || letterASCIIVal == -52) {
					if (isStartOfWord) {
						// TODO: update the follwers table
						
					} else if (letterASCIIVal == -52) {
						counts[i - 1]--;

					} else {
						// TODO: update like regular letter
					}
				} else {
					// ignore the char
				}
			}

		}
	}
}