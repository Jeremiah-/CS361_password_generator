import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.TreeSet;
import java.util.ArrayList;

public class Passwords_3 {

	public static void main(String args[]) throws IOException {

		if (args.length < 4) {
			System.out.println("Error: not enough arguments given. Format should be \'Passwords reference-Filename N k reject-file\'");
			return;
		} else if (args.length > 4) {
			System.out.println("Error: too many arguments given. Format should be \'Passwords reference-Filename N k reject-file\'");
			return;
		}

		String referenceTextFileName = args[0];

		// the number of passwords to generate
		int n = Integer.parseInt(args[1]);

		// the length of the passwords
		int k = Integer.parseInt(args[2]);

		if (n < 1 || k < 1) {
			System.out.println("N and k must be > 1");
			return;
		}

		String rejectWordsFileName = args[3];

		File referenceTextFile;
		File rejectTextFile;

		try {
			referenceTextFile = new File(referenceTextFileName);
			rejectTextFile = new File(rejectWordsFileName);
		} catch (NullPointerException e) {
			System.out.println("Error: file name given is null.");
			return;
		}

		int[][][] followers = new int[26][26][26];
		int[][] secondLetterFollowers = new int[26][26];
		int[] counts = new int[26];
		int[] starters = new int[26];

		Scanner fileReader;
		Scanner rejectReader;

		try {
			fileReader = new Scanner(referenceTextFile);
			rejectReader = new Scanner(rejectTextFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: file name given was not found.");
			return;
		}


		// reads the file and constructs the followers table
		while (fileReader.hasNext()) {
			String word = fileReader.next().toLowerCase();
			boolean isStartOfWord = true;
			boolean isSecondLetter = false;
			// treat '-' as two seperate words. other characters just ignore and treat as one word.

			int previousLetterVal = -1;
			int prepreLetterVal = -1;
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
						isSecondLetter = true;
					} else if (isSecondLetter) {
						isSecondLetter = false;
						secondLetterFollowers[previousLetterVal][letterIndexVal] += 1;
					} else {
						secondLetterFollowers[prepreLetterVal][previousLetterVal] += 1; // for the first layer matrix to get second letter
						followers[prepreLetterVal][previousLetterVal][letterIndexVal] += 1; // this is the rest of the matrix used for rest of password letters
					}

					prepreLetterVal = previousLetterVal;
					previousLetterVal = letterIndexVal;
					isStartOfWord = (i == word.length() - 1) ? true : false;

				}

			}
		}


		// reads through the reject file and stores the words
		// TODO: doesn't consider non-letters.
		TreeSet<String> rejectWords = new TreeSet<String>();
		while (rejectReader.hasNext()) {
			rejectWords.add(rejectReader.next().toLowerCase());
		}

		// writeFollowersTable(followers);
		int startersTotal = getStartersTotal(starters); // precomputation for getStarteringLetter() function
		int[] secondLetterTotals = getFirstMatrixTotals(secondLetterFollowers); // this is the same as the original assignment, just for the second letter now
		int[][] followersTotals = getFollowersTotals(followers); // precomputation for getIntermediateLetter() function
		StringBuilder password = new StringBuilder(); // append all passwords to the same StringBuilder() object
		ArrayList<String> passWords = new ArrayList<String>();
		boolean containsReject = false;

		for (int num = 0; num < n; ++num) {
			Random randGen = new Random();

			// get starting letter for this password
			char prepreLetter = '-';
			char previousLetter = '-';
			if (k > 1) {
				prepreLetter = getStartingLetter(starters,
														startersTotal,
														randGen);
				password.append(prepreLetter);
			}

			if (k > 2) {
				// TODO: get second letter
				previousLetter = getSecondLetter(prepreLetter, secondLetterFollowers, secondLetterTotals, randGen);
				password.append(previousLetter);
			}

			// get the rest of the letters for this password
			if (k > 3) {
				for (int i = 2; i < k; i++) {
					char intermediateLetter = getIntermediateLetter(prepreLetter, previousLetter,
																	followers,
																	followersTotals,
																	randGen);
					password.append(intermediateLetter);
					prepreLetter = previousLetter;
					previousLetter = intermediateLetter; // this current letter will become the next loop's previous letter
				}
			}

			String pw = password.toString();

			outerLoop:
			for (String s : rejectWords) {
				if (s.length() > 3 && pw.contains(s.subSequence(0, s.length()))) {
					System.out.println("Rejected password \"" + pw + "\" because of substring \"" + s + "\"");
					containsReject = true;
					break outerLoop;
				}
			}

			if (!containsReject) {
				passWords.add(pw);
			}

			password.delete(0, password.length());
			containsReject = false;
			// passwords.append("\n");
		}

		System.out.println("Passwords are:");

		for (int i = 0; i < passWords.size(); i++) {
			System.out.println(" " + passWords.get(i));
		}
		// System.out.print(passwords.toString());

	}



	// This function returns the sum of all the frequencies of
	// starting letters in the reference text.
	static int getStartersTotal(int[] starters) {
		int sum = 0;

		for (int i = 0; i < starters.length; ++i) {
			sum += starters[i];
		}

		return sum;
	}


	static int[] getFirstMatrixTotals(int[][] secondLetterFollowers) {
		int[] totals = new int[26];

		for (int i = 0; i < secondLetterFollowers.length; ++i) {

			int sum = 0;
			for (int j = 0; j < secondLetterFollowers[0].length; ++j) {
				sum += secondLetterFollowers[i][j];
			}

			totals[i] = sum;
		}

		return totals;
	}

	// This function returns an array of sums of all the frequencies of
	// intermediately occurring letters in the reference text.
	static int[][] getFollowersTotals(int[][][] followers) {
		int[][] totals = new int[26][26];

		//  imagine it as x and y are coordinates on a flat map and we're recordring how
		// deep each x,y coordinate is
		for (int x = 0; x < followers.length; ++x) {
			for (int y = 0; y < followers[0].length; ++y) {
				int sum = 0;
				for (int z = 0; z < followers[0][0].length; z++) {
					sum += followers[x][y][z];
				}

				totals[x][y] = sum;
			}

			
		}

		return totals;
	}



	// This function takes some gacky parameters in order to
	// simply return the first letter of a password,
	// based on the starting letter frequencies info acquired
	// from the reference text.
	static char getStartingLetter(int[] starters,
									int startersTotal,
									Random randGen) {
		int seed = randGen.nextInt(startersTotal);

		int sum = 0;

		// used if the seed is never greater than the sum
		// (can happen if at the end of array)
		int lastNonZero = 0; 
		for (int i = 0; i < starters.length; ++i) {

			sum += starters[i];
			if (sum >= seed) {
				return (char)(i + 97);
			}

		}



		System.out.println("printed - in getStartingLetter()");
		System.out.printf("sum: %d\n", sum);
		System.out.printf("seed: %d\n", seed);
		return 'z'; // should never be reached
	}

	static char getSecondLetter(char previousLetter, int[][] secondLetterFollowers, 
													int[] firstLayerTotals,
													Random randGen){
		int sum = 0;
		int previousLetterIndex = (int)previousLetter - 97;
		int seed = randGen.nextInt(firstLayerTotals[previousLetterIndex]);

		for (int i = 0; i < secondLetterFollowers[0].length; ++i) {
			sum += secondLetterFollowers[previousLetterIndex][i];

			if (sum >= seed) {
				return (char)(i + 97);
			}
		}

		System.out.println("printed - in getSecondLetter()");

		return '-'; // should never be reached

	}

	// This function takes some gacky parameters in order to
	// simply return an intermediately occurring letter of a password,
	// based on the follower letter frequencies info acquired
	// from the reference text, as well as the character that it is following, "previousLetter.""
	static char getIntermediateLetter(char prepreLetter, 
										char previousLetter,
										int[][][] followers,
										int[][] followersTotals,
										Random randGen) {
		int sum = 0;
		int prepreLetterIndex = (int)prepreLetter - 97;
		int previousLetterIndex = previousLetter - 97;
		int seed = randGen.nextInt(followersTotals[prepreLetterIndex][previousLetterIndex]);

		for (int i = 0; i < followers[0][0].length; ++i) {
			sum += followers[prepreLetterIndex][previousLetterIndex][i];

			if (sum >= seed) {
				return (char)(i + 97);
			}
		}

		System.out.println("Printed - in getIntermediateLetter()");
		return '-'; // should never be reached
	}


}