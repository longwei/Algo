package ch6_7;

/*
 * how to implement *, /, - using only +
 * sol:
 * a - b : a + (-b)
 * a * b : add a to itself for b times
 * a / b:  add b to itself until xb > a; care negative
 * NTS:
 * note to negative, zero conditions.
 */
public class CalcCPU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(mult(3,5));
//		System.out.println(mult(3,0));
//		System.out.println(divide(3,5));
//		System.out.println(divide(5,3));
		System.out.println(divide(0,3));
		System.out.println(divide(3,-1));
	}
	
	public static int negative(int i){
		int neg = 0;
		int d = i > 0? -1: 1;
		while(i != 0){
			i += d;
			neg += d;
		}
		return neg;
		
	}
	
	public static int substract(int a, int b){
		return a + negative(b);
	}
	
	public static int mult(int a, int b){
		if(a < b) return mult(b, a);
		int ret = 0;
		for(int i = abs(b); i != 0; i--){
			ret += a;
		}
		if(b < 0) ret = negative(ret);
		return ret;
	}
	
	public static int abs(int a){
		if (a < 0) return negative(a);
		return a;
	}
	
	public static int divide(int a, int b){
		if(b == 0) throw new ArithmeticException("ERROR");
		int ret = 0;
		int product = 0;
		int absa = abs(a);
		int absb = abs(b);
		while( product + absb <= absa){
			product += absb;
			ret++;
		}
		if ( (a > 0) ^ (b > 0) ) ret = negative(ret);
		return ret;
	}

}
