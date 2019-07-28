package ModifiedBinaryTree;
/*  

Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
Example 1:

Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]
Example 2:

Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]
Example 3:

Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]
 */
public class Pattern5 {

	public static void main(String[] args) {
		int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");

	}

	private static int[] findRange(int[] array, int key) {
		int[] result = new int[] {-1,-1};
		result[0] = (int)find(array,key,true);
		if(result[0] == -1)
			return result;
		result[1] = find(array,key,false);
		
		return result;
	}

	private static int find(int[] array, int key,boolean firstindex) {
		int n = array.length;
		if(key > array[n-1])
			return -1;
		int index = -1;
		int start=0, end = n-1;
		while(start<= end) {
			int mid = start+(end-start)/2;
			if(key < array[mid]) {
				end=mid-1;
			}
			else if(key > array[mid]) {
				start = mid+1;
			}
			else {
					index = mid;
				if(firstindex) {
					end = mid-1;
				}
				else {
					start = mid+1;
					
				}
			}
		}
		
		
		return index;
		
	}

}
