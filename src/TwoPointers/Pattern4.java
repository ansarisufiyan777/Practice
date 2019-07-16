package TwoPointers;

import java.util.*;


/*  
 *
Problem Statement
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

 
 * */

public class Pattern4 {
	public static List<List<Integer>> tripletSumEqZero(int[] arry){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arry);
		for(int i=0;i<arry.length-2;i++) {
			search(arry,-arry[i],i+1,result);
		}
		return result;
	}
	
	
	private static void search(int[] arry, int target, int left, List<List<Integer>> result) {
		int right = arry.length-1;
		while(left<right) {
			int remainder = target - arry[left];
			if(remainder == arry[right])
			{
				result.add(Arrays.asList(-target,arry[left],arry[right]));
				left++;
				right--;
				while(left<right && arry[left] == arry[left-1])
					left++;
				while(left < right && arry[right] == arry[right+1])
					right--;
				
			}
			else if( remainder > arry[right]) {
				left++;
			}
			else
				right--;
		}
		
	}


	public static void main(String[] args) {
		System.out.println(tripletSumEqZero(new int[] {-3, 0, 1, 2, -1, 1, -2}));
		System.out.println(tripletSumEqZero(new int[] {-5, 2, -1, -2, 3}));

	}

}
