/*  
 
Problem Statement:

Given a binary tree and a number ‘S’, find all paths from root-to-leaf such
that the sum of all the node values of each path equals ‘S’.

Example1:
S:23
output:
1 -> 7 -> 4 and 1 -> 9 -> 2  
				   1
				 /   \
			    2     3
			   / \   / \
			  4   5 6   7

Example2:
S:16
output:
12 -> 7 -> 4 and 12 -> 1 -> 10      


			       12
				 /   \
			    7     1
			   /     / \
			  9    10   5

    */

package BreathFirstTree;

import java.util.*;

public class Pattern2 {

	public static void main(String[] args) {
		 TreeNode root = new TreeNode(12);
		    root.left = new TreeNode(7);
		    root.right = new TreeNode(1);
		    root.left.left = new TreeNode(4);
		    root.right.left = new TreeNode(10);
		    root.right.right = new TreeNode(5);
		    int sum = 23;
		    List<List<Integer>> result = findPaths(root, sum);
		    System.out.println("Tree paths with sum " + sum + ": " + result);
	}

	private static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPath = new ArrayList<>();
		List<Integer> currentPath = new LinkedList<>();
		findPaths(root, sum, allPath, currentPath);
		return allPath;
	}

	private static void findPaths(TreeNode root, int sum,List<List<Integer>> output, List<Integer> current) {
		if(root == null)
			return;
		current.add(root.val);
		if(sum == root.val && root.left == null && root.right == null) {
			output.add(new ArrayList<Integer>(current));
		}
		else{
			findPaths(root.left, sum-root.val, output, current);
			findPaths(root.right,sum-root.val,output,current);
		}
		current.remove(current.size()-1);
		
	}

}
