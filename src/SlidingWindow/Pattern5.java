package SlidingWindow;

import java.util.HashMap;

/* 
  Given an array of characters where each character represents a fruit tree, 
  you are given two baskets and your goal is to put maximum number of fruits in each basket. 
  The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. 
You will pick one fruit from each tree until you cannot, i.e., 
you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

 
 Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5


Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 
 
 *  */
public class Pattern5 {

	public static void main(String[] args) {
		System.out.println("Maximum fruits of count of 2 types :"+(int)maxfruitcount2type(new char[] {'A', 'B', 'C', 'A', 'C'}));
		System.out.println("Maximum fruits of count of 2 types :"+(int)maxfruitcount2type(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));

	}

	private static int maxfruitcount2type(char[] trees) {
		HashMap<Character, Integer> frequecyCount = new HashMap<Character, Integer>();
		int startWindow = 0;
		int fruitcount = 0;
		for(int endWindow=0;endWindow<trees.length;endWindow++) {
			char rightchar = trees[endWindow];
			fruitcount++;
			frequecyCount.put(rightchar,frequecyCount.getOrDefault(rightchar, 0)+1);
			while(frequecyCount.size() > 2) {
				char leftchar = trees[startWindow];
				frequecyCount.put(leftchar,frequecyCount.get(leftchar)-1);
				if(frequecyCount.get(leftchar)==0) 
					frequecyCount.remove(leftchar);
				startWindow++;
				fruitcount--;
			}
		}
		return fruitcount;
	}

}
