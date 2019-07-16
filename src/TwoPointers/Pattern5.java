package TwoPointers;

public class Pattern5 {
	public static int searchTriplet(int[] arry,int target) {
		int closestSoFar = Integer.MAX_VALUE;
		for(int i=0;i<arry.length-2;i++) {
			int left = i+1,right = arry.length-1;
			while(left<right) {
				int remainder = target - arry[i]-arry[left]-arry[right];
				if(remainder == 0) {
					return target;
				}
				if( Math.abs(remainder) < Math.abs(closestSoFar))
					closestSoFar = remainder;
				
				if( remainder > 0)
					left++;
				else
					right--;
				
			}
		}
		return target-closestSoFar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		 System.out.println(searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		 System.out.println(searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

}
