package SlidingWindow;

import java.util.HashMap;

/*   
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
 *  letters with any letter, find the length of the longest substring having the same letters after replacement.
 * 
 * 
 * 
 * */
public class pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("aabccbb", 2));
		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("abbcb", 1));

		System.out.println("logest substring of same letter after k replace: "+logest_substring_of_sameletter_k_replace("abccde", 1));

	}

	/*
	 * We iterate through string char by char
	 * we are going use dynamic sliding window pattern where widow has staring and ending
	 * dynamic becase window can grow or slink
	 * 
	 * we will crete a hapmap we use this hapmap to map char and it's index
	 * once hashmap size reach k+1 we start slinking it
	 * 
	 * and also keep track of maximum repeating letter
	 * 
	 * 
	 * */

	/*
	
		Starwidow = 0
		endwindow =0
		
		hashmap =key-> character
				value -> no of occrence
		
		maxoccrence in currenct window sofar -> maxletter
		
		algorithm:
		start = 0
		end =3
		maxletter =0->1->2
		window = [a,a,b,c] 
		hasmap{
		 a-> 2
		 b-> 1
		 c-> 1
		}
		
		start sinking window once it has length of is equal to k
		
		  end -start - maxletter >= k
		  3-0-2>=k
		  1>=2
		  
		
		aabccbb



	*/
	
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
