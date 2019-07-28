package ModifiedBinaryTree;
/*                                                   
 
 Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.
 
 
 Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
  This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.

Write a function to return the next letter of the given ‘key’.
 
 
 * 
 * */
public class Pattern4 {

	public static void main(String[] args) {
		 System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		 System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		 System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		 System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}

	private static char searchNextLetter(char[] cs, char key) {
		int start = 0, end= cs.length-1;
		if(key > cs[end] || key < cs[start])
			return cs[0];
		
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(key < cs[mid]) {
				end=mid-1;
			}
			else if(key > cs[mid]) {
				start=mid+1;
			}
			else {
				return cs[(mid+1)%cs.length];
			}
		}
		return cs[start%(cs.length)];
		
	}

}
