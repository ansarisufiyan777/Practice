package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class Pattern6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Logest string without any repeating characters :" + (int)longestSubStringNoRepeat("aabaeccbb"));
		System.out.println("Logest string without any repeating characters :" + (int)longestSubStringNoRepeat("abbbb"));
		System.out.println("Logest string without any repeating characters :" + (int)longestSubStringNoRepeat("abccde"));
		System.out.println("Logest string without any repeating characters :" + (int)longestSubStringNoRepeat("aabccbb"));
	}

	private static int longestSubStringNoRepeat(String str) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxlength = 0;
		int startWindow = 0;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char rightchar = str.charAt(endWindow);
			if(map.containsKey(rightchar)) 
			{
				startWindow = Math.max(startWindow, map.get(rightchar)+1);
			}
			map.put(rightchar,endWindow);
			maxlength = Math.max(maxlength, endWindow-startWindow+1);			
		}		
		return maxlength;
	}
}
