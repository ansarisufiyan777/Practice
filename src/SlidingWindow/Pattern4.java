package SlidingWindow;

import java.util.HashMap;

/*
 * longest substring with k distinct characters
 * 
 *
 * 
Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".


 * 
 * 
 * */
/*
 * 
 *1. Iterate through string char by char untill we reach max of k distinct and also added into hashset(key as character and value as number of occrence)
 *2. once we reach there we remember its length
 *3. we follow sliding window patter which move a step ahead and sinking from beggining
 *4. we strink window as possible as less then k
 * */


public class Pattern4 {

	public static void main(String[] args) {
		System.out.println("longest string with K distrinct character: "+ (int)subStringKDistrinct("arraci",2));
		System.out.println("longest string with K distrinct character: "+ (int)subStringKDistrinct("araaci",1));
		System.out.println("longest string with K distrinct character: "+ (int)subStringKDistrinct("cbbebi",3));


	}

	private static int subStringKDistrinct(String str, int k) {
	
		HashMap<Character, Integer> frequecyMapper = new HashMap<Character, Integer>();
		int startWindow =0;
		int minsubstringLenght = Integer.MIN_VALUE;
		for(int endWindow=0;endWindow<str.length();endWindow++) {
			char leftchar = str.charAt(endWindow);
			frequecyMapper.put(leftchar, frequecyMapper.getOrDefault(leftchar,0)+1);
			while(frequecyMapper.size() > k) {
				char rightchar = str.charAt(startWindow);
				frequecyMapper.put(rightchar, frequecyMapper.get(rightchar)-1);
				if(frequecyMapper.get(rightchar)==0)
					frequecyMapper.remove(rightchar);		
				startWindow++;
			}
			minsubstringLenght = Math.max(endWindow-startWindow+1,minsubstringLenght);
		}
		return minsubstringLenght;
	
	}

}
