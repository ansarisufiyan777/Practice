package SlidingWindow;
import java.util.*;

/*  
 String Anagrams (hard)
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
Try it yourself
 * 
 * 
 * */
public class Pattern10 {
	
	public static List<Integer> findAllAnanaGram(String str, String pattern){
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Character,Integer> charFrequencymap = new HashMap<>();
		
		for(char ch : pattern.toCharArray())
			charFrequencymap.put(ch, charFrequencymap.getOrDefault(ch,0)+1);
		
		
		int startWindow=0,matched=0;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char rightchar = str.charAt(endWindow);
			if(charFrequencymap.containsKey(rightchar)) {
				charFrequencymap.put(rightchar,charFrequencymap.get(rightchar)-1);
				if(charFrequencymap.get(rightchar)==0)
					matched++;
			}
			if(matched == charFrequencymap.size()) {
				list.add(startWindow);
			}
			if(endWindow-startWindow+1 >= pattern.length()) {
				char leftchar = str.charAt(startWindow++);
				if(charFrequencymap.containsKey(leftchar)) {
					if(charFrequencymap.get(leftchar) == 0) {
						matched--;
					}
					charFrequencymap.put(leftchar,charFrequencymap.get(leftchar)+1);
					
				}
			}
		}		
		return list;
	}
	public static void main(String[] args) {
		System.out.println(findAllAnanaGram("ppqp","pq"));
		System.out.println(findAllAnanaGram("abbcabc","abc"));
	}

}
