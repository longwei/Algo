package random_bit;

import java.util.BitSet;

/* A magnitude pole of an array A consisting of N integers that
 * for index k, [0, k-1] < A[k] and [k-1, N] > A[k]
 * sol: two passes, set the positive and negative pole in bitset,
 * AND the bitsets to get the indexes,
 * 
 * Jan11, 2013, tripAdvisor OJ
 * Lesson Learned:
 * 1. get familiar with the API!;
 * 2. don't copy even your own code. 
 *    - the second iteration should start from end
 * 3. think about the easiest case first and then cover the edge cases
*/
public class MagnitudePole {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 4, 2, 2, 3, 1, 4, 7, 8, 6, 9 };
		System.out.println(magnitudePole(test));
	}

	public static int magnitudePole(int[] A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		BitSet bits1 = new BitSet(A.length);
		BitSet bits2 = new BitSet(A.length);
		for (int i = 0; i < A.length; ++i) {
			if (A[i] >= max) {
				bits1.set(i);
				max = A[i];
			}
		}
		for (int i = A.length - 1; i >= 0; --i) {
			if (A[i] <= min) {
				bits2.set(i);
				min = A[i];
			}
		}
		bits1.and(bits2);
		return bits1.nextSetBit(0);
	}

}
