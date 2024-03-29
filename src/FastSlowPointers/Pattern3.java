package FastSlowPointers;
/*  
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, 
 * leads us to number �1�. All other (not-happy) numbers will never reach �1�. 
 * Instead, they will be stuck in a cycle of numbers which does not include �1�.
 * 
 * 
Input: 23   
Output: true (23 is a happy number)  
Explanations: Here are the steps to find out that 23 is a happy number:


 * 
 * */
public class Pattern3 {

	public static void main(String[] args) {
		System.out.println("hello world");
		System.out.println(Pattern3.finddigitcycle(23));
	    System.out.println(Pattern3.finddigitcycle(12));

	}

	private static boolean finddigitcycle(int num) {
		int slow=num,fast=num;
		do
		{
			slow = count_individual_digit(slow);
			fast = count_individual_digit(count_individual_digit(fast));

		}while(slow != fast);
		
		return slow == 1;
		
	}
	private static int count_individual_digit(int num) {
		int total =0;
		while(num>0) {
			int remainder = num%10;
			total += (remainder * remainder);
			num = num/10;
		}
		return total;
	}

}
