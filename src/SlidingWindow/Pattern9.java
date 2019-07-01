package SlidingWindow;

import java.util.HashMap;
/*   
 * Given a string and a pattern, 
 * find out if the string contains any
 *  permutation of the pattern.Permutation is  
 *   defined as the re-arranging of the characters 
 *   of the string. For example, 
 *    “abc” has the following six permutations:
 * 
 * 
 * 
 * Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
Try it 
 * 
 * 
 * */
public class Pattern9 {

	public static void main(String[] args) {
		System.out.println(StringcontainPattern("oidbacaf","aabc"));
		System.out.println(StringcontainPattern("odicf","dc"));
		System.out.println(StringcontainPattern("bcdxabcdy","bcdyabcdx"));
		System.out.println(StringcontainPattern("aaacb","abc"));
		System.out.println("\n\n\n");
		System.out.println(StringcontainPattern1("oidbacaf","aabc"));
		System.out.println(StringcontainPattern1("odicf","dc"));
		System.out.println(StringcontainPattern1("bcdxabcdy","bcdyabcdx"));
		System.out.println(StringcontainPattern1("aaacb","abc"));
	}
	
	private static boolean StringcontainPattern1(String str, String pattern) {
		HashMap<Character,Integer> frequencymap = new HashMap<Character, Integer>();
		for(char chr : pattern.toCharArray())
			frequencymap.put(chr, frequencymap.getOrDefault(chr, 0)+1);
		
		int startWindow=0,matched=0;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char rightchar = str.charAt(endWindow);
			if(frequencymap.containsKey(rightchar)) {
				frequencymap.put(rightchar,frequencymap.get(rightchar)-1);
				
				if(frequencymap.get(rightchar) == 0)
					matched++;
			}
			
			if(matched == frequencymap.size())
				return true;
			
			if(endWindow >= pattern.length() -1) {
				char leftchar = str.charAt(startWindow);
				if(frequencymap.containsKey(leftchar)) { 
					if (frequencymap.get(leftchar) == 0)
					matched--;
					frequencymap.put(leftchar, frequencymap.get(leftchar)+1);				
				}
					startWindow++;
			}			
		}		
		return false;
	}
	private static boolean StringcontainPattern(String str, String pattern) {
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<pattern.length();i++)
			map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i), 0)+1);
		
		int startWindow =0;
		int matched=0;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char leftchar = str.charAt(endWindow);
			if(map.containsKey(leftchar)){
				map.put(leftchar, map.get(leftchar)-1);
				matched++;
			}
			else {
				char rightchar = str.charAt(startWindow);
				if(map.containsKey(rightchar)) {
					matched--;
				}
				startWindow++;
			}
			if(matched == map.size())
				return true;
			
		}
		
		return false;
	}

}
