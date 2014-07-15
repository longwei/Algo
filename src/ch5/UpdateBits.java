package ch5;

import CtCILibrary.AssortedMethods;

public class UpdateBits {
	/* 5.1
	 * N = 1000000, M = 1011, i = 2, j = 6
	 * output: N = 10001001100
	 * sol:
	 * 1. clear the bit through i j
	 * 2. shift N i
	 * 3. OR them
	 */
	public static int updateBits(int n, int m, int i, int j){
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right = (1 << i) -1;
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
		
	}
	
	public static void main(String[] args) {
		int a = 103217;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 13;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 4, 12);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}

}
