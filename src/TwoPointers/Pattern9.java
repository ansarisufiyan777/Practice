package TwoPointers;

public class Pattern9 {

	public static void main(String[] args) {
		for(int item : sort(new int[] {1,0,2,1,0}))
			System.out.print(item +" ");
		System.out.println();
		for(int item : sort(new int[] {2,2,0,1,2,0}))
			System.out.print(item +" ");
		System.out.println();
	}

	private static int[] sort(int[] arry) {
		int low= 0,high = arry.length-1;
		
		for(int i=0;i<=high;) {
			
			if(arry[i]==0) {
				swap(arry,low,i);
				low++;
				i++;
			}
			else if(arry[i]==1) {
				i++;				
			}
			else
			{
				swap(arry,high,i);
				high--;
			}
		}
		return arry;
	}
	private static void swap(int[] arry,int i,int j) {
		int temp = arry[i];
		arry[i] = arry[j];
		arry[j] = temp;
	}

}
