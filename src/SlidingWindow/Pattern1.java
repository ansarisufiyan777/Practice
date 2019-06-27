package SlidingWindow;

import java.util.Arrays;

/*

 Given an array, find the average of all subarrays of size ‘K’ in it.

 Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

 (1+3+2+6−1)/5=>2.2
 (3+2+6−1+4)/5=>2.8
 (2+6−1+4+1)/5=>2.4
 ...
 */

public class Pattern1 {
	public static double[] bruteForce(int[] arry,int k) {
	 
		int n = arry.length;
		double[] result = new double[n-k+1];
		if(n < k)
			return result;

		for(int i = 0; i < n-k+1; i++ ) {
			int total=0;
			for(int j=i;j<k+i;j++) {
				total += arry[j];
			}
			result[i] = (double)total/k;
		}
		return result;

	}
	public static void main(String[] args) {
		System.out.println("Average "+ Arrays.toString(bruteForce(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5)));

	}

}
