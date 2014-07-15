package ch5;
/*
 * 5.7
 * you got a stream of 0101010101....(0|1)
 * remove one away
 * how do you know 0 or 1?
 * if count(0) = count(1), because we know something is missing, the previous condition must be count(0) = count(1) + 1; we removed a 1;
 * if count(0) < count(1), 0 must be removed
 * if count(0) > count(1), then 1 must removed.
 * the length of n is log(n), so the overall runtime is log(n)^2.
 * 
 * brute solution.
 * 
 */

public class FindMissing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
