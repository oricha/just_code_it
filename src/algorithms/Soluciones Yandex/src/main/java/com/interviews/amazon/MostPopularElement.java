/**
 * Given an integer array, find the most frequent number and it's count in the
 * array Write the code in O(1) space. Eg 1 , 3, 4, 5, 2, 2, 3, 2 Output Most
 * frequent number is 2. The frequency is 3. Return the output as string in
 * 'number: frequency' format. e.g. 2: 3 (Please note the space after : and
 * frequency. If multiple numbers have the same highest frequency return the
 * smallest number.
 * 
 * @author Zion
 *
 */

// TODO Try to solvet
public class MostPopularElement {

	public static void main(String[] args) {
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 7, 7, 7 };
		int[] array = {1 , 3, 4, 5, 2, 2, 3, 2};
		System.out.println(getPopularElement(array));
	}

	public static int getPopularElement(int[] a) {
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		for (int i = 0; i < (a.length - 1); i++) {
			temp = a[i];
			tempCount = 0;
			for (int j = 1; j < a.length; j++) {
				if (temp == a[j])
					tempCount++;
			}
			if (tempCount > count) {
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}

}
