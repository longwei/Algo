package ch1;

/*
 * 1.3 if a string a permutation of another string
 */
public class IsPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] pairs = {
				{"apple", "papel"},
				{"carrot", "tarroc"},
				{"hello", "llloh"},
				{"", ""},
				{null, null}
		};
		for(String[] pair: pairs){
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = isPermutation2(word1, word2);
			System.out.println(word1 + " - "+word2 + ": " + anagram);
		}
	}
	public static boolean isPermutation(String s, String t){
		if(s == null || t == null) return false;
		return sortString(s).equals(sortString(t));
	}
	public static String sortString(String s){
		char[] s_array = s.toCharArray();
		java.util.Arrays.sort(s_array);
		return new String(s_array);
	}
	public static boolean isPermutation2(String s, String t){
		if(s == null || t == null) return false;
		if(s.length() != t.length()) return false;
		int[] ASCII_hits = new int[256];
		char[] s_array = s.toCharArray();
		for(char c:s_array){//count each char
			ASCII_hits[c]++;
		}
		for(int i=0; i < t.length(); ++i){
			int c = t.charAt(i);
			--ASCII_hits[c];
			if (ASCII_hits[c] < 0){
				return false;
			}
		}
		return true;
	}

}
