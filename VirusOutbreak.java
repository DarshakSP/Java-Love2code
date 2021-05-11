package test;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Virus Outbreak
In the Martian land faraway, a new virus has evolved and is attacking the individuals at a fast pace. The scientists have figured out the virus composition, V. The big task is to identify the people who are infected. The sample of N people is taken to check if they are POSITIVE or NEGATIVE. A report is generated which provides the current blood composition B of the person. 


POSITIVE or NEGATIVE ?
If the blood composition of the person is a subsequence of the virus composition V, then the person is identified as POSITIVE otherwise NEGATIVE.


Example:
Virus Composition, V = coronavirus
Blood Composition of the person , B = ravus

The person in question is POSITIVE as B is the subsequence of the V. 
The scientists are busy with their research for medicine and request you to build a program which can quickly figure out if the person is POSITIVE or NEGATIVE. They will provide you with the virus composition V and all the people’s current blood composition. Can you help them?


Note: The virus and blood compositions are lowercase alphabet strings.

Input Format
The first line of the input consists of the virus composition, V
The second line of he input consists of the number of people, N
Next N lines each consist of the blood composition of the ith person, Bi


Constraints
1<= N <=10

1<= |B|<= |V|<= 10^5



Output Format
For each person, print POSITIVE or NEGATIVE in a separate line

Sample TestCase 1
Input
coronavirus
3
abcde
crnas
onarous*/
public class VirusOutbreak {

	/**
	 * String to use if the blood composition of the person is a subsequence of
	 * the virus composition
	 */
	private static final String POSITIVE = "POSITIVE";

	/**
	 * String to use if the blood composition of the person is a subsequence of
	 * the virus composition
	 */
	private static final String NEGATIVE = "NEGATIVE";

	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		final String virusComposition = bufferedReader.readLine();
		final int noOfPeople = Integer.parseInt(bufferedReader.readLine().trim());

		for (int i = 0; i < noOfPeople; i++) {
			String[] bloodCompositions = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			for (int j = 0; j < bloodCompositions.length; j++) {
				boolean isSubSequence = isSubSequenceString(virusComposition, bloodCompositions[j]);
				System.out.println(isSubSequence ? POSITIVE : NEGATIVE);
			}
		}
		bufferedReader.close();
	}

	/**
	 * Check if the blood composition of the person is a subsequence of the
	 * virus composition or not.
	 * 
	 * @param virusComposition
	 *            The virus composition string.
	 * @param bloodComposition
	 *            The blood composition string.
	 * @return True if bloodComposition is a subsequence of virusComposition,
	 *         False otherwise.
	 */
	private static boolean isSubSequenceString(String virusComposition, String bloodComposition) {
		int j = 0;
		boolean isSubSequenceFound = false;
		for (int i = 0; i < virusComposition.length(); i++) {
			if (bloodComposition.charAt(j) == virusComposition.charAt(i)) {
				++j;
				// Equal means all the characters of str1 are
				// found in str2 in order
				if (j == bloodComposition.length()) {
					isSubSequenceFound = true;
				}
			}

			if (isSubSequenceFound) {
				break;
			}

		}
		return isSubSequenceFound;
	}
}
