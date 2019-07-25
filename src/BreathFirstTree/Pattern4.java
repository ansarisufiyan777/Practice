package BreathFirstTree;

public class Pattern4 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(0);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(1);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(5);

	    System.out.println("Tree has path sequence: " + findPath(root, new int[] { 1, 0, 7 }));
	    System.out.println("Tree has path sequence: " + findPath(root, new int[] { 1, 1, 6 }));

	}

	private static boolean findPath(TreeNode root, int[] arry) {
		return findPath(root,arry,0);
	}

	private static boolean findPath(TreeNode root, int[] arry, int i) {
		if(root == null)
			return false;
		
		if(i >= arry.length || arry[i] != root.val)
			return false;
		if(root.left == null && root.right == null && i == arry.length-1)
			return true;		
		
		return findPath(root.left, arry, i+1)||findPath(root.right, arry, i+1);
	}

}
