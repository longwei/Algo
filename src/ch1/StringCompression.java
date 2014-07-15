package ch1;

/*
 * 1.5 string compression aabcccccaa => a2b1c5a2, 
 * if the result string.length is greater than original string, return original
 * the trick here is to use the StringBuffer to append
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compressBetter("abbbbbbbbbbbbca"));
	}
	
	public static String compressBetter(String str){
		if (countCompression(str) >= str.length()){
			System.out.println(countCompression(str));
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); ++ i){
			if(str.charAt(i)== last){
				count++;
			} else{
				mystr.append(last);
				last = str.charAt(i);
				mystr.append(count);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
		
	}
	public static int countCompression(String str){
		int size = 0;
		int count = 1;
		char last = str.charAt(0);
		for(int i = 1; i < str.length(); ++i){
			if( str.charAt(i) == last){
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

}
