package ModifiedBinaryTree;
/*
Given a sorted array of numbers, find if a given number ‘key’ is present in the array. 
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ 
if it is present in the array, otherwise return -1.

*/
public class Pattern1 {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 6, 10 }, 10));
		System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
		System.out.println(search(new int[] { 10, 6, 4 }, 10));
		System.out.println(search(new int[] { 10, 6, 4 }, 4));

	}

	private static int search(int[] array, int key) {
		int end = array.length-1;
		int start = 0;
		boolean isAsc = array[start] < array[end];
		while(start<=end) {
			int middle = start + (end-start)/2;
			if(array[middle] == key)
				return middle;
			if(isAsc) {
				if(key < array[middle]) {
					end = middle - 1;
				}
				else {
					start = middle + 1;
				}
			}
			else { // descending
				if(key > array[middle]) {
					end = middle-1;
				}
				else {
					start = middle+1;
				}
				
			}
		}
				
		return -1;
	}

}
