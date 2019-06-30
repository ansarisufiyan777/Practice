package SlidingWindow;

import java.util.HashMap;

/*  
 
Problem Statement
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest subarray having all 1s.

Example 1:

0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest subarray of 1s having length 6.
Example 2:

0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest subarray of 1s having 

 
 */

public class Pattern8 {

	public static void main(String[] args) {
		
		System.out.println("Logest sub array containg 1's after replace of k 0's:"+(int)logestsubarraykreplace(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2));
		System.out.println("Logest sub array containg 1's after replace of k 0's:"+(int)logestsubarraykreplace(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
		System.out.println("Logest sub array containg 1's after replace of k 0's:"+(int)logestsubarraykreplace2(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2));
		System.out.println("Logest sub array containg 1's after replace of k 0's:"+(int)logestsubarraykreplace2(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));

	}

	private static int logestsubarraykreplace(int[] array, int k) {
	
		int startWindow=0;
		HashMap<Integer,Integer> frequcymapper = new HashMap<>();
		int maxreaptecurrentwindow =0,maxlength=0;
		
		for(int endWindow=0;endWindow<array.length;endWindow++) {
			int rightvalue = array[endWindow];
			frequcymapper.put(rightvalue, frequcymapper.getOrDefault(rightvalue,0)+1);
			maxreaptecurrentwindow = Math.max(frequcymapper.get(rightvalue),maxreaptecurrentwindow);
			if(endWindow-startWindow+1-maxreaptecurrentwindow > k) {
				int leftvalue = array[startWindow];
				frequcymapper.put(leftvalue, frequcymapper.get(leftvalue)-1);
				startWindow++;
			}
			maxlength = Math.max(maxlength,endWindow-startWindow+1);
		}	
		return maxlength;
	}
	
	private static int logestsubarraykreplace2(int[] array, int k) {
		int startWindow=0;
		int onescount=0;
		int maxonecount=0;
		for(int endWindow=0;endWindow<array.length;endWindow++) {
			
			if(array[endWindow]==1)
				onescount++;
			
			if(endWindow-startWindow+1-onescount > k) {
				if(array[startWindow]==1)
					onescount--;
				startWindow++;
			}
			maxonecount = Math.max(maxonecount, endWindow-startWindow+1);
		}
		return maxonecount;
	}

}
