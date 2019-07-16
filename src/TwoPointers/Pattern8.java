package TwoPointers;

import java.util.*;

/* 
Problem Statement
Given an array with positive numbers and a target number, find all subarrays in it whose product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30 
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six subarrays whose product is less than the target.
Example 2:

Input: [8, 2, 6, 5], target=50 
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
Explanation: There are seven subarrays whose product is less than the target.

 */
public class Pattern8 {

	public static List<List<Integer>> findSubArray(int[] arry,int target){
		List<List<Integer>> result = new ArrayList<>();
		int product = 1, left =0;
		for(int right=0;right<arry.length;right++) {
			product *= arry[right];
			while(product >= target && left < arry.length)
				product /= arry[left++];
			
			List<Integer> tempItem = new LinkedList<Integer>();
			for(int i=right;i>=left;i--) {
				tempItem.add(0,arry[i]);
				result.add(new ArrayList<>(tempItem));
			}		
		}
		return result;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubArray(new int[] { 2, 5, 3, 10 }, 30));
	    System.out.println(findSubArray(new int[] { 8, 2, 6, 5 }, 50));
	}

}
