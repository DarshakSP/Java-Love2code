package test;

import java.util.Scanner;

public class ZerolessCode {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows in first matrix:");
		int N = s.nextInt();
		System.out.println("Enter matrix  value :");
		int A[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j]);
			}
			System.out.println();
		}

		System.out.println("Count of Zeroless : " + checkZeroless(N, A));
		s.close();
	}
	
	/**
	 * Check matrix without zeroless value.
	 * @param N matrix size
	 * @param A The matrix
	 * @return count The count zeroless value.
	 */
	public static int checkZeroless(int N, int A[][]) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == 1) {
					count += checkNext(i, j, N, A);
				}
			}
		}
		return count;
		
	}

	/**
	 * Check next row and column value is zero or one.
	 * @param i row value
	 * @param j column value
	 * @param N matrix size
	 * @param A The matrix
	 * @return count The count zeroless value.
	 */
	private static int checkNext(int i, int j, int N, int[][] A) {
		int count = 0;
		if ((!(j < N - 1) || (A[i][j + 1] == 1))
				&& (!(i < N - 1) || (A[i + 1][j] == 1))) {
			count++;
		} 
		return count;
	}
}
