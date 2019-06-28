package SlidingWindow;
/*
 Maximum Sum Subarray of Size K (easy)
 
 Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
 
 */
public class Pattern2 {
	public static int maxSumSubArray(int[] arry,int k) {
		int maxSum = 0;
		int startWindow = 0;
		int windowSum = 0;
		for(int endWindow = 0;endWindow<arry.length;endWindow++) {
			windowSum += arry[endWindow];
			if(endWindow >= k-1 ) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arry[startWindow++];
			}
		}
		return maxSum;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Max sum of subarray of size k "+ maxSumSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
		System.out.println("Max sum of subarray of size k "+ maxSumSubArray(new int[] {2, 3, 4, 1, 5}, 2));
	}

}
