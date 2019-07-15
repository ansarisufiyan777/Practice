package TwoPointers;
/*

Problem Statement
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].

 
 * */
public class Pattern2 {
	public static int removeDuplicate(int[] arry) {
		int nonDuplicate = 1;
		for(int i=1;i<arry.length;i++) {
			if(arry[nonDuplicate-1] != arry[i])
				arry[nonDuplicate++] = arry[i];
			
		}
		
		return nonDuplicate;		
	}
	/* 
	  Problem 1: Given an unsorted array of numbers and a target ‘key’,
	  remove all instances of ‘key’ in-place and return the new length of the array.
	  
	  
	  Example 1:

		Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
		Output: 4
		Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
		Example 2:
		
		Input: [2, 11, 2, 2, 1], Key=2
		Output: 2
		Explanation: The first two elements after removing every 'Key' will be [11, 1].
	 */
	public static int removeElement(int[] arry,int key) {
		int nonKey = 0;
		for(int i =0;i<arry.length;i++) {
			if(arry[i] != key) {
				arry[nonKey] = arry[i];
				nonKey++;
			}
		}
		
		return nonKey;
	}
	public static void main(String[] args) {
		System.out.println(removeDuplicate(new int[] {2, 3, 3, 3, 6, 9, 9}));
		System.out.println(removeDuplicate(new int[] {2, 2, 2, 11}));
		System.out.println(removeElement(new int[] {3, 2, 3, 6, 3, 10, 9, 3},3));
		System.out.println(removeElement(new int[] {2, 11, 2, 2, 1},2));
	}

}
