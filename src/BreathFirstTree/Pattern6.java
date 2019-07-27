package BreathFirstTree;
/*  
 
 
 
 
 *   */
public class Pattern6 {
	public static int diameter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  TreeNode root = new TreeNode(1);
		    root.left = new TreeNode(2);
		    root.right = new TreeNode(3);
		    root.left.left = new TreeNode(4);
		    root.right.left = new TreeNode(5);
		    root.right.right = new TreeNode(6);
		    System.out.println("Tree Diameter: " + findDiameter(root));
		    root.left.left = null;
		    root.right.left.left = new TreeNode(7);
		    root.right.left.right = new TreeNode(8);
		    root.right.right.left = new TreeNode(9);
		    root.right.left.right.left = new TreeNode(10);
		    root.right.right.left.left = new TreeNode(11);
		   
		    System.out.println("Tree Diameter: " + findDiameter(root));
	}
	private static int findDiameter(TreeNode root)
	{ 
		diameter =0;
		find(root);
		return diameter;
	}
	private static int find(TreeNode root) {
		if(root == null)
			return 0;
		int leftTree = find(root.left);
		int rightTree = find(root.right);
		diameter = Math.max(leftTree+rightTree+1,diameter);
	
		return Math.max(leftTree, rightTree)+1;
		
	}

}
