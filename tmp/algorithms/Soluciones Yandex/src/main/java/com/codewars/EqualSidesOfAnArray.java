import java.util.Arrays;

public class EqualSidesOfAnArray {
	
	public static int findEvenIndex(int[] arr) {
	    // your code
		
		
		int result = -1;
		for(int i = 0 ; i < arr.length-1; i++){
			int[] left = Arrays.copyOfRange(arr, 0, i);
			int[] right = Arrays.copyOfRange(arr, i+1, arr.length);
			if( sumArray(left) == sumArray(right)){
				return i;
			}
		}
		
		return result;
	  }
	
	private static int sumArray(int [] array){
		int sum = 0;
		
		for(int i= 0; i < array.length; i++){
			sum = sum + array[i];
		}
		return sum;
		
	}
	
	 public static int findEvenIndex2(int[] A) {
	        int sumRight = Arrays.stream(A).sum() - A[0];
	        int sumLeft = 0;
	        for (int i = 1; i < A.length; i++) {
	            sumLeft += A[i-1];
	            sumRight -= A[i];
	            if (sumLeft == sumRight) return i;
	        }
	        return -1;
	    }

}
