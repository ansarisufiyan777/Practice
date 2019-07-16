package TwoPointers;
/*   
 * Maximum Trapping Water (medium)
Suppose you are given an array containing non-negative numbers representing heights of a set of buildings. Now, because of differences in heights of buildings water can be trapped between them. Find the two buildings that will trap the most amount of water. Write a function that will return the maximum volume of water that will be trapped between these two buildings.

Example 1:

Input: [1, 3, 5, 4, 1]
Output: 6
Explanation: The maximum water will be trapped between buildings of height 3 and 4.
Example 2:

Input: [3, 2, 5, 4, 2]
Output: 9
Explanation: The maximum water will be trapped between buildings of height 3 and 4.
Example 3:

Input: [1, 4, 3, 2, 5, 8, 4]
Output: 20
Explanation: The maximum water will be trapped between buildings of height 4 and 4.
 * 
 * */
public class Pattern13 {
	public static int MaxTrapWater(int[] arry) {
		int max = Integer.MIN_VALUE;
		int left = 0,right = arry.length-1;
		while(left < right) {
			int currentArea =0;
			if(arry[left] < arry[right]) {
				 currentArea = (right-left)*arry[left];
				left++;
			}
			else {
				 currentArea = (right-left)*arry[right];
				right--;
			}
			max = Integer.max(currentArea, max);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MaxTrapWater(new int[] { 1, 3, 5, 4, 1 }));
	    System.out.println(MaxTrapWater(new int[] { 3, 2, 5, 4, 2 }));
	    System.out.println(MaxTrapWater(new int[] { 1, 4, 3, 2, 5, 8, 4 }));
	}

}
