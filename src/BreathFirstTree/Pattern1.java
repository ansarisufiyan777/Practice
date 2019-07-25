package BreathFirstTree;

import java.util.Stack;

/*
Given a binary tree and a number ‘S’, find if the tree has a path from 
root-to-leaf such that the sum of all the node values of that path equals ‘S’.

Example1:
S:23
output:true
				   1
				 /   \
			    2     3
			   / \   / \
			  4   5 6   7

Example2:
S:16
output:false

			       12
				 /   \
			    7     1
			   /     / \
			  9    10   5


 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

public class Pattern1 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + hasPath(root, 23));
		System.out.println("Tree has path: " + hasPath(root, 16));

	}

	public static boolean hasPath(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		if(sum == root.val && root.left == null && root.right == null)
			return true;
		
		return hasPath(root.left, sum-root.val) || hasPath(root.right, sum-root.val);

	}

}
