package Knapsack;

public class Pattern1 {

	public static void main(String[] args) {
		int[] weights = { 2, 3, 1, 4 };
		int[] profits = { 4, 5, 3, 7 };
		System.out.println((int)bruteForce(weights,profits,5));
		weights = new int[]{1, 2, 3, 5};
		profits = new int[]{1, 6, 10, 16};
		System.out.println((int)bruteForce(weights,profits,7));
		System.out.println((int)bruteForce(weights,profits,6));

	}

	private static int bruteForce(int[] weights, int[] profits, int capacity) {
		return bruteForce(weights,profits,capacity,0);
	}

	private static int bruteForce(int[] weights, int[] profits, int capacity, int i) {
		if(weights.length != profits.length || capacity <= 0 || i < 0 || i >= profits.length)
			return 0;
		int profit1=0;
		if(weights[i] <= capacity)
			profit1 = profits[i]+bruteForce(weights, profits, capacity-weights[i], i+1);
		
		int profit2 = bruteForce(weights, profits, capacity, i+1);
		return Math.max(profit1, profit2);
	}
}
