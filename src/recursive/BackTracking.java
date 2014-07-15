package recursive;
/*
 * famous permutation
 */
import java.util.Arrays;

public class BackTracking {

	/**
	 * @param args
	 */
	static int[] A = new int[4];
	public static void main(String[] args) {
//		binary(4);
		kstring(4,2);
	}
	/*
	 * generate all the strings of n bits 2^n 
	 */
	public static void binary(int n){
		if(n < 1){
			System.out.println(Arrays.toString(A));
		}else{
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}
	
	/*
	 * generate strings of length n, element from 0~k-1
	 */
	public static void kstring(int n, int k){
		if(n < 1){
			System.out.println(Arrays.toString(A));
		}else{
			for(int j = 0; j < k; j++){
				A[n-1] = j;
				kstring(n-1, k);
			}
		}
	}

}
