package SlidingWindow;

import java.util.HashMap;

/*  
 Smallest Window containing Substring (hard)
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Example 1:

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"
Example 2:

Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".
Example 3:

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
 * 
 * 
 * 
 * */


public class Pattern11 {
	public static String smallestSubStringofpatter(String str,String pattern) {
		HashMap<Character,Integer> charFrequencyMap = new HashMap<>();

		for(char ch: pattern.toCharArray()) 
			charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0)+1);
		
		int startWindow=0,matched=0,min=Integer.MAX_VALUE,startindex = -1,endindex=-1;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char rightchar = str.charAt(endWindow);
			if(charFrequencyMap.containsKey(rightchar)){
				charFrequencyMap.put(rightchar,charFrequencyMap.get(rightchar)-1);
				if(charFrequencyMap.get(rightchar) == 0) {
					matched++;
				}
			}
			while(matched == charFrequencyMap.size()) {
				if(min > endWindow-startWindow+1) {
					startindex = startWindow;
					endindex =  endWindow;
				}
				min = Math.min(min, endWindow-startWindow+1);
				char leftchar = str.charAt(startWindow++);
				if(charFrequencyMap.containsKey(leftchar)) {
					if(charFrequencyMap.get(leftchar)==0)
						matched--;
					charFrequencyMap.put(leftchar,charFrequencyMap.get(leftchar)+1);
				}
			}
		}
		
		return startindex==-1?"xxx":str.substring(startindex, endindex+1);
	}
	public static void main(String[] args) {
		System.out.println(smallestSubStringofpatter("aabdec","abc"));
		System.out.println(smallestSubStringofpatter("abdabca","abc"));
		System.out.println(smallestSubStringofpatter("adcad","abc"));
	}

}
