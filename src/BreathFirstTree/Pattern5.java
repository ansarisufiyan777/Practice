/*   
 Given a binary tree and a number ‘S’, find all paths in the tree such
  that the sum of all the node values of each path equals ‘S’.
   Please note that the paths can start or end at  any node but all paths
    must follow direction from parent to child (top to bottom).
 
 
 */

package BreathFirstTree;

import java.util.*;

public class Pattern5 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree has path: " + countPaths(root, 11));

	}

	private static int countPaths(TreeNode root, int i) {
		if(root == null)
			return 0;
		
		return countPaths(root,i,new LinkedList<Integer>());
		
	}

	private static int countPaths(TreeNode root, int sum, List<Integer> currentpath) {
		if(root == null)
			return 0;
		int count =0;
		int currentsum = 0;
		currentpath.add(root.val);
	    ListIterator<Integer> pathIterator = currentpath.listIterator(currentpath.size());
		while(pathIterator.hasPrevious()) {
			int previous = pathIterator.previous();
			currentsum+= previous;
			if(currentsum == sum)
				count++;
				
		}
		
		count+=countPaths(root.left,sum,currentpath);
		count+=countPaths(root.right, sum, currentpath);
		
		currentpath.remove(currentpath.size()-1);
		return count;
	}

}
