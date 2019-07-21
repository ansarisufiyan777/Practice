package SlidingWindow;

import java.util.HashMap;

/*   
 * Given a string with lower case letters only, if you are allowed to replace no more than ‘k’
 *  letters with any letter, find the length of the longest substring having the same letters after replacement.
 * 
 * 
 * 
 * */
/*
 * We iterate through string char by char
 * we are going use dynamic sliding window pattern where widow has staring and ending
 * dynamic because window can grow or sink
 * 
 * we will create a hashMAP we use this hashMAP to map char and it's index
 * once hashMAP size reach k+1 we start sink it
 * 
 * and also keep track of maximum repeating letter
 * 
 * 
 * */
public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("aabccbb", 2));
		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("abbcb", 1));

		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("abccde", 1));

	}


	private static int logest_substring_of_sameletter_k_replace(String str, int k) {

		int starWindow = 0;
		int maxreapetcharincurrentwindow = 0;
		int maxlength=0;
		HashMap<Character, Integer> charFrequecyCount = new HashMap<Character, Integer>();
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char rightchar = str.charAt(endWindow);
			charFrequecyCount.put(rightchar, charFrequecyCount.getOrDefault(rightchar, 0)+1);
			maxreapetcharincurrentwindow = Math.max(maxreapetcharincurrentwindow,charFrequecyCount.get(rightchar));
			if(endWindow-starWindow-maxreapetcharincurrentwindow+1>k) {
				char leftchar = str.charAt(starWindow);
				charFrequecyCount.put(leftchar,charFrequecyCount.get(leftchar)-1);
				starWindow++;
			}
			maxlength = Math.max(maxlength, endWindow-starWindow+1);
		}

		return maxlength;
	}

}
