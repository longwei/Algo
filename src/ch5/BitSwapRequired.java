package ch5;

/*
 * determine the number of bits to convert A to B
 * sol:
 * XOR, and count the ones
 * 
 * swap odd and even bits
 * sol:
 * 1, mask all odd a, and even b,
 * 2. shift a, b
 * 2. a OR b
 */
public class BitSwapRequired {

	/**
	 * @param args
	 */
	public static int bitSwapCount(int a, int b){
		int count = 0;
		for( int c = a ^ b; c !=0; c= c >> 1){
			count += c & 1;
		}
		return count;
	}
	
	public static int swapOddEven(int a){
		return ((a & 0xaaaaaaaa) >> 1 ) | ( (a & 0x55555555) << 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
