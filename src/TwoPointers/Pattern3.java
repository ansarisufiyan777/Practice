
package TwoPointers;
/*  
	Problem Statement
	Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
	
	Example 1:
	
	Input: [-2, -1, 0, 2, 3]
	Output: [0, 1, 4, 4, 9]
	Example 2:
	
	Input: [-3, -1, 0, 1, 2]
	Output: [0 1 1 4 9]
 * 
 * 
 * */
public class Pattern3 {
	public static int[] square(int[] arry) {
		int[] squareArry = new int[arry.length];
		int index = arry.length-1;
		for(int i=squareArry.length-1,j=0;i>j;) {
			if( (arry[i]*arry[i]) > (arry[j]*arry[j]) ){
				squareArry[index] = (arry[i]*arry[i]);
				i--;
			}
			else
			{
				squareArry[index] =(arry[j]*arry[j]);
				j++;
			}
			index--;
		}
		return squareArry;
	}
	public static void main(String[] args) {
		int[] result = square(new int[]{-2, -1, 0, 2, 3});
		for (int num : result)
		      System.out.print(num + " ");
		    System.out.println();
		result =  square(new int[]{-3, -1, 0, 1, 2});
		for (int num : result)
		      System.out.print(num + " ");
		    System.out.println();

	}
}
