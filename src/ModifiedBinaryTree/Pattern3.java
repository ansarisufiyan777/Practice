package ModifiedBinaryTree;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
	    System.out.println(searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
	    System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
	    System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
	}

	private static int searchFloorOfANumber(int[] arry, int key) {
		int start = 0, end = arry.length-1;
		if(key < arry[start]) {
			return -1;
		}
		while(start <= end) {
			int middle = start+(end-start)/2;
			if(key == arry[middle])
				return middle;
			else if(key < arry[middle]) {
				end = middle-1;
			}
			else{
				start = middle+1;
			}
			
		}
		return end;
	}

}
