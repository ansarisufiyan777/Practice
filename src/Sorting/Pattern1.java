package Sorting;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {1,3,4,2,7,6,5};
		bubbleSort(arry);
		for(int i : arry) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void bubbleSort(int[] arry) {
		for(int i=0;i<arry.length;i++) {
			for(int j=0;j<arry.length-1-i;j++) {
				if(arry[j] > arry[j+1]){
					int temp = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = temp;
				}
			}
		}
		
	}

}
