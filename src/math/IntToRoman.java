package math;

/*
 * rule:
 * 1. III for I*3
 * 2. IX for X - I, at most 1
 * 3. XI for X + I; at most 3
 * 
 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
 * X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
 * C can be placed before D and M to make 400 and 900 according to the same pattern[5]
 * 
 * TODO sol:
 * 1. when XIIII happens, change it to IX
 * 2. extend symbol table.
 * 
 * follow up 
 * Roman to Int
 * 
 * 1954 as MCMLIV
 * 1990 as MCMXC
 * 2008 as MMVIII
 */
public class IntToRoman {

	/**
	 * @param args
	 */
	private String[] romanSymbol = {"M", "CM", "D", "CD", "C", "XC","L", "XL","X", "IX", "V", "IV", "I"};
	private int[]    romanValue =  {1000, 900, 500,  400, 100,  90,  50,  40, 10,   9,    5,   4,    1};
	
	public static String intToRoman(int a){
		return null;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
