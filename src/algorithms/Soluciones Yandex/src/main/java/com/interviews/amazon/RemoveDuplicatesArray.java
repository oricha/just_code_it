/**
 * Remove duplicates from array in linear time and without extra arrays
 * 
 * @author Zion
 *
 */
public class RemoveDuplicatesArray {

	public static void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are:");
		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

	public static void main(String[] args) {
//TODO not works if Xi > array.length
//		int array[] = { 3, 6, 3, 4, 5, 1, 7, 7 };
		int array[] = { 7, 4, 6, 3, 5, 4, 6, 2 };
		int n = array.length;
		printRepeating(array, n);
	}

//	public static void printRepeating(int array[], int n) {
//		int i, j, k;
//		boolean swap = true;
//
//		while (swap) {
//			swap = false;
//			for (i = 0; i < n; i++) {
//				if (array[i] != i && array[i] != array[array[i]]) {
//					j = array[i];
//					k = array[j];
//					array[i] = k;
//					array[j] = j;
//					swap = true;
//				}
//
//			}
//		}
//	}

}
