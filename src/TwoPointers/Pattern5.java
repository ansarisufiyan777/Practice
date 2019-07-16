package TwoPointers;

import java.util.*;

/*  

Problem Statement
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

The triplet [1, 1, 1] has the closest sum to the target.
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

 * 
 * */
public class Pattern5 {
	public static int searchTriplet(int[] arry,int target){
		Arrays.sort(arry);
		int closestsofar=Integer.MAX_VALUE;
		for(int i=0;i<arry.length-2;i++) {
			int left = i+1, right = arry.length-1;
			while(left < right) {
				int remainder = target - arry[i] - arry[left]-arry[right];
				if(remainder == 0)
					return target;
				
				if(Math.abs(remainder) < Math.abs(closestsofar))
					closestsofar = remainder;
				
				if(remainder>0)
					left++;
				else
					right--;
			}
		}
		return target-closestsofar;
	}
	public static void main(String[] args) {
		 System.out.println(searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		 System.out.println(searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		 System.out.println(searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

}
