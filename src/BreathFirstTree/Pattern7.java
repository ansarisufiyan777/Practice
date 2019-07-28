package BreathFirstTree;
/* Find the path with the maximum sum in a given binary tree. 
 * Write a function that returns the maximum sum. 
 * A path can be defined as a sequence of nodes between any two leaf nodes and doesn’t
 * necessarily pass through the root.
 *    */
public class Pattern7 {

	public static int maxsum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("Maximum Path Sum: " + maximumPathSum(root));

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		System.out.println("Maximum Path Sum: " + maximumPathSum(root));

		root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		System.out.println("Maximum Path Sum: " + maximumPathSum(root));
	}

	private static int maximumPathSum(TreeNode root) {
		maxsum = Integer.MIN_VALUE;
		findMaximumPathSum(root);
		return maxsum;
	}
	private static int findMaximumPathSum(TreeNode root) {
		if(root == null)
			return 0;

		int leftsubstree = findMaximumPathSum(root.left);
		int rightsubstree = findMaximumPathSum(root.right);

		leftsubstree = Math.max(leftsubstree, 0);
		rightsubstree = Math.max(rightsubstree, 0);
		int currentNodeSum = leftsubstree + rightsubstree + root.val;

		maxsum = Math.max(currentNodeSum,maxsum);

		return Math.max(leftsubstree,rightsubstree)+root.val;


	}

}
