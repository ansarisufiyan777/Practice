package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*   
 * Triplets with Smaller Sum
 * Given an array arr of unsorted numbers and a target sum,
 *  count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 *   where i, j, and k are three different indices. 
 * 
 * 
 * Write a function to return the list of all such triplets instead of the count. 
 * How will the time complexity change in this case?
 * */

public class Pattern7 {
	public static List<List<Integer>> searchTriplet(int[] arry,int target) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<arry.length-2;i++) {
			searchTriplet(arry,target-arry[i],i,result);
		}
		return result;
		
	}
	private static void searchTriplet(int[] arry, int target, int first, List<List<Integer>> result) {
		int right = arry.length-1;
		int left = first+1;
		while(left < right) {
			if(arry[left]+arry[right] < target) {
				for(int i=right;i>left;i--)
					result.add(Arrays.asList(arry[first],arry[left],arry[i]));
				left++;
			}
			else
				right--;
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(searchTriplet(new int[] { -1, 0, 2, 3 }, 3));
		 System.out.println(searchTriplet(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

}
