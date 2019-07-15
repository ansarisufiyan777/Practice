package TwoPointers;

import java.util.HashMap;

/*
Problem Statement
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The number at index 1 and 3 add up to 6: 2+4=6
Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The number at index 0 and 1 add up to 11: 2+9=11
Try it yourself
 
 
 * 
 * */
public class Pattern1 {
	public static int[] targetSum(int[] arry,int target) {
		for(int start=0,end=arry.length-1;start<end;) {
			int localtarget = arry[start]+arry[end];
			if(localtarget == target)
				return new int[] {start,end};
			else if(localtarget > target)
				end--;
			else
				start++;
		}
		return new int[] {-1,-1};
	}
	public static int[] targetSumUsingHashMap(int[] arry,int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<arry.length;i++) {
			int remainder = target - arry[i];
			if(map.containsKey(remainder)) {
				return new int[] {map.get(remainder),i};
			}
			map.put(arry[i],i);
		}
		return new int[] {-1,-1};
	}
	public static void main(String[] args) {
		int[] result = targetSum(new int[] {1, 2, 3, 4, 6},6);	
		System.out.println("Target sum ["+ result[0] +" "+result[1]+" ]");
		result = targetSum(new int[] {2, 5, 9, 11},11);
		System.out.println("Target sum ["+ result[0] +" "+result[1]+" ]");
		
		result = targetSumUsingHashMap(new int[] { 4, 6,1, 2, 3},6);	
		System.out.println("Target sum ["+ result[0] +" "+result[1]+" ]");
		result = targetSumUsingHashMap(new int[] { 11,2,9, 5},11);
		System.out.println("Target sum ["+ result[0] +" "+result[1]+" ]");
	}

}
