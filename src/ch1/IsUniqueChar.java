package ch1;

import java.util.HashSet;

/*
 * 1.1 determine if a string has all unique chars
 */
public class IsUniqueChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abcde", "hello", null, "", "a"};
		for(String w: words){
			System.out.println(isUniqueChar4(w));
		}

	}
	public static boolean isUniqueChar(String str){
		if(str == null) return false;
		int strlen = str.length();
		if(strlen == 0) return false;
		if(strlen > 256) return false;
		boolean[] ASCII_hit = new boolean[256];
		for(int i = 0; i < strlen; ++i){
			int val = str.charAt(i);
			if(ASCII_hit[val]) return false;
			ASCII_hit[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueChar2(String str){
		if(str ==  null) return false;
		if(str.length() == 0) return false;
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; ++i){
			for(int j = i + 1 ; j != chars.length; ++j){
				if(chars[i] == chars[j]) return false;
			}
		}
		return true;
	}
	
	public static boolean isUniqueChar3(String str){
		if(str ==  null) return false;
		if(str.length() == 0) return false;
		char[] chars = str.toCharArray();
		java.util.Arrays.sort(chars);
		for(int i = 1; i != str.length(); ++i){
			if (chars[i-1] == chars[i]) return false;
		}
		return true;
	}

    public static boolean isUniqueChar4(String str){
        if(str ==  null) return false;
        if(str.length() == 0) return false;
        HashSet<Integer> record  = new HashSet<Integer>();
        int strlen = str.length();
        for(int i = 0; i < strlen; i++){
            int val = str.charAt(i);
            if(record.contains(val)) return false;
            record.add(val);
        }
        return true;
    }

	
	
}
