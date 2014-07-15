package ch1;

/*
 *  URL encoding
 *  1.4 write a method to replace all space in a string with %20
 */
import CtCILibrary.AssortedMethods;

public class EcapeSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpace(arr, str.length());	
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
	}
	
	public static void replaceSpace(char[] str, int length){
		int spaceCount = 0;
		for(int i=0; i < length; ++i){
			if(str[i] == ' ') {spaceCount++;}
		}
		int newLength = length + spaceCount * 2;
		//do it in space.
		str[newLength] = '\0';
		for(int i = length - 1; i >= 0; --i){
			if(str[i] == ' '){
				str[newLength -1] = '0';
				str[newLength -2] = '2';
				str[newLength -3] = '%';
				newLength = newLength - 3;
			} else{
				str[newLength -1 ] = str[i];
				newLength--;
			}
		}
	}

    
}
