import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.lang.StringBuilder;

public class Passwords {

	public static void main(String args[]) throws IOException {

		if (args.length < 3) {
			System.out.println("Error: not enough arguments given. Format should be \'Passwords reference-Filename N k\'");
			return;
		} else if (args.length > 3) {
			System.out.println("Error: too many arguments given. Format should be \'Passwords reference-Filename N k\'");
			return;
		}

		String referenceTextFileName = args[0];

		// the number of passwords to generate
		int n = Integer.parseInt(args[1]);

		// the length of the passwords
		int k = Integer.parseInt(args[2]);

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

			int previousLetterVal = -1;
			for (int i = 0; i < word.length() - 1; i++) {

				int letterIndexVal = (int)word.charAt(i) - 97;

				if (letterIndexVal >= 0 && letterIndexVal < 26) {

					// count the total number of times a
					// letter (excluding end letters) occurs
					if (i != word.length() - 1) {
						counts[letterIndexVal] += 1;
					}

					if (isStartOfWord) {
						// record occurrence of starting letter
						starters[letterIndexVal] += 1;
						isStartOfWord = false;
					} else {
						followers[previousLetterVal][letterIndexVal] += 1;
					}

					previousLetterVal = letterIndexVal;
					isStartOfWord = (i == word.length() - 1) ? true : false;

				}

				// ignore the char

			}
		}

		writeFollowersTable(followers);
		StringBuilder passwords = new StringBuilder();

		for (int num = 0; num < n; ++num) {
			Random randGen = new Random();
			int seed = randGen.nextInt(100); // needs to be changed ***

			// get starting letter for this password
			char startingLetter = getStartingLetter(seed, starters);
			passwords.append(" " + startingLetter);

			// get intermediate and end letters for this password
			for (int pChar = 0; pChar < k; ++pChar) {
				seed = randGen.nextInt(100); // needs to be changed ***
				char intermediateLetter = getIntermediateLetter(seed, followers, startingLetter);
				passwords.append(intermediateLetter);
			}

			passwords.append("\n");
		}

		System.out.println("Passwords are:");
		System.out.print(passwords.toString());

	}


	static char getStartingLetter(int seed, int[] starters) {
		return 'a'; // change ***
	}



	static char getIntermediateLetter(int seed, int[][] followers, char startingLetter) {
		int sum = 0;
		int startingLetterIndex = (int)startingLetter - 97;

		for (int i = 0; i < followers[0].length; ++i) {
			sum += followers[startingLetterIndex][i];

			if (sum > seed) {
				// return char
			}
		}

		return 'a'; // change ***
	}


	static void writeFollowersTable(int[][] followers) throws IOException {

		// setup FileWriter
		File followersTableFile;

		try {
			followersTableFile = new File("followersTable.txt");
		} catch (NullPointerException e) {
			System.out.println("Error: file name given is null.");
			return;
		}

		followersTableFile.createNewFile();
		FileWriter writer = new FileWriter(followersTableFile);


		// print letters for column title
		for (int i = 0; i < followers.length; ++i) {
			char colLetter = (char)(i + 65);

			if (i == 0) {
				writer.write("            ");
			}

			writer.write(colLetter + "     ");
		}

		// print row titles and frequencies in followers table
		for (int i = 0; i < followers.length; ++i) {
			char rowLetter = (char)(i + 65); // letter for row title
			writer.write("\n" + rowLetter + ":     ");

			for (int j = 0; j < followers[0].length; ++j) {
				String formattedString = String.format("%6d", followers[i][j]);
				writer.write(formattedString);
			}

			writer.write("\n");
		}

		writer.flush();
		writer.close();

	}


}