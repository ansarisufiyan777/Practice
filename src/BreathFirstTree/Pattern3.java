package BreathFirstTree;

/*


*/
public class Pattern3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(0);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(1);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(5);
	    System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
	}

	private static int findSumOfPathNumbers(TreeNode root) {
		return findSumOfPathNumbers(root,0,0);
	}

	private static int findSumOfPathNumbers(TreeNode root,Integer totalpathsum,Integer currentpathsum) {
		
		if(root == null)
			return totalpathsum;
	
		currentpathsum = (currentpathsum*10)+root.val;
		if(root.left == null && root.right == null) {
			return currentpathsum;
		}
		
		return	findSumOfPathNumbers(root.left, totalpathsum,currentpathsum)
			+findSumOfPathNumbers(root.right, totalpathsum,currentpathsum);
	
	}

}
