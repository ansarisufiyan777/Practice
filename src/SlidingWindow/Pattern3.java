package SlidingWindow;
/* 
 
 Smallest subarray with given sum
 
 
 */
public class Pattern3 {

	public static void main(String[] args) {
		System.out.println("Smallest Subarray of given sum :" + smallestSubArray(new int[]{2, 1, 5, 2, 3, 2},7)); 
		System.out.println("Smallest Subarray of given sum :" + smallestSubArray(new int[]{2, 1, 5, 2, 8},7)); 
		System.out.println("Smallest Subarray of given sum :" + smallestSubArray(new int[]{3, 4, 1, 1, 6},8)); 

	}

	/*
	 * smallestWindowSofar = 2
	 * startwindow = 1
	 * endwindow = 3
	 * windowsum = 8
	 * 
	 * */
	
	private static int smallestSubArray(int[] arr, int sum) {
		
		int smallestWindowSofar=Integer.MAX_VALUE;
		int startWindow =0;
		int windowSum = 0;
		for(int endWindow=0;endWindow<arr.length;endWindow++) {
		
			windowSum += arr[endWindow];
			while(windowSum >= sum) {
				smallestWindowSofar =Math.min(smallestWindowSofar,  endWindow-startWindow+1); // 
				windowSum -= arr[startWindow];
				startWindow++;
			}
			
		}
		return smallestWindowSofar;
		
		
	}

}
