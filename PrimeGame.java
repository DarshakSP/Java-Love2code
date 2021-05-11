package test;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;



/*
Prime Game (100 Marks)
Rax, a school student, was bored at home in the pandemic. He wanted to play but there was no one to play with. He was doing some mathematics questions including prime numbers and thought of creating a game using the same. After a few days of work, he was ready with his game. He wants to play the game with you.


GAME:
Rax will randomly provide you a range [ L , R ] (both inclusive) and you have to tell him the maximum difference between the prime numbers in the given range. There are three answers possible for the given range.
There are two distinct prime numbers in the given range so the maximum difference can be found.
There is only one distinct prime number in the given range. The maximum difference in this case would be 0.
There are no prime numbers in the given range. The output for this case would be -1.

To win the game, the participant should answer the prime difference correctly for the given range.

Example:
------------
Range: [ 1, 10 ]
The maximum difference between the prime numbers in the given range is 5.
Difference = 7 - 2 = 5

Range: [ 5, 5 ]
There is only one distinct prime number so the maximum difference would be 0.

Range: [ 8 , 10 ]
There is no prime number in the given range so the output for the given range would be -1.


Input Format
The first line of input consists of the number of test cases, T
Next T lines each consists of two space-separated integers, L and R

Constraints
1<= T <=10
2<= L<= R<=10^6

Output Format
For each test case, print the maximum difference in the given range in a separate line. 

Sample TestCase 1
Input
5
5 5
2 7
8 10
10 20
4 5
*/
public class PrimeGame {

	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int noOfValue = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < noOfValue; i++) {
			List<Integer> primeNumbers = new ArrayList<Integer>();
			String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			for (int j = 0; j < firstMultipleInput.length / 2; j++) {
				int start = Integer.parseInt(firstMultipleInput[0]);
				int end = Integer.parseInt(firstMultipleInput[1]);

				// CASE 2 :
				// There is only one distinct prime number in the given range.
				// The maximum difference in this case would be 0.
				if (start == end) {
					System.out.println(0);
				} else {
					for (int n = start; n <= end; n++) {
						if (isPrimeNumber(n)) {
							primeNumbers.add(n);
						}
					}

					if (primeNumbers.isEmpty()) {
						// CASE 3 ;
						// There are no prime numbers in the given range. The
						// output for this case would be -1.
						System.out.println(-1);
					} else {
						int difference = primeNumbers.get(primeNumbers.size() - 1) - primeNumbers.get(0);

						if (difference > 1) {
							// CASE 1 :
							// There are two distinct prime numbers in the given
							// range so the maximum difference can be found.
							System.out.println(difference);
						} else {
							// CASE 2 :
							// There is only one distinct prime number in the
							// given range. The maximum difference in this case
							// would be 0.
							System.out.println(0);
						}
					}
				}

			}
		}
		bufferedReader.close();
	}

	/**
	 * Check whether given number is prime number or not.
	 * 
	 * @param number
	 *            The number to check.
	 * @return True if given number is prime number, False otherwise
	 */
	private static boolean isPrimeNumber(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
