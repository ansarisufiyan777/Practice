package TwoPointers;

import java.util.Arrays;

/*   

Problem Statement
Given an array arr of unsorted numbers and a target sum, 
count all triplets in it such that arr[i] + arr[j] + arr[k] < target 
where i, j, and k are three different indices.
Write a function to return the count of such triplets.

Example 1:
Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Example 2:
Input: [-1, 4, 2, 1, 3], target=5 
Output: 4

Explanation: There are four triplets whose sum is less than the target: 
[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
  
   */
public class Pattern6 {
	public static int findTriplet(int[] arry,int target) {
		Arrays.sort(arry);
		int result = 0;
		for(int i=0;i<arry.length-2;i++) {
			int left=i+1,right=arry.length-1;
			while(left<right) {
				int targetsum = arry[i] + arry[left] + arry[right];
				if(targetsum < target) {
					result += right-left;
					left++;
				}
				else
					right--;
				
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		 System.out.println(findTriplet(new int[] { -1, 0, 2, 3 }, 3));
		 System.out.println(findTriplet(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

}
