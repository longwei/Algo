package math;

/*
 * reverse digits of an integer
 * 123 -> 321
 * -890 ->-98
 */
public class reverseDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(12345));
		System.out.println(reverse(-980));
//		System.out.println(reverse(021));
	}
	
	public static int reverse(int n){
		int result = 0;
		while(n != 0){
			result = result * 10 + n  % 10;
			n /= 10;
		}
		return result;
	}
	
	public static int reverseRec(int x, int mul){
		if ( 0 == x ){return mul;}
		return reverseRec(x / 10, mul * 10 + x % 10);
	}
}
