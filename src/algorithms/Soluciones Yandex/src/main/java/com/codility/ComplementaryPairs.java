import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplementaryPairs {

	// find K-complementary pairs in a given array
	// Given Array A, pair (i, j) is K- complementary if K = A[i] + A[j];
//	O(2n) = O(n)
	public static List<Pair> pairs(int K, int[] A) {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		List<Pair> result = new ArrayList<>();
		
		for (int i = 0; i < A.length; i++) {
			final long value = ((long) K) - A[i];
			final int j = map.containsKey(value) ? map.get(value) : 0;
			map.put(value, i );
		}

		for (int j = 0; j < A.length; j++) {
			final long value = A[j];
			if(map.containsKey(value)){
				result.add(new Pair(map.get(value), j));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 5, 9 };
		int K = 10;
		for(Pair item : pairs(K, A)){
			System.out.println(K+"= A["+item.i+"] + A["+item.j+"]");
		}
	}

	public static class Pair {
		int i;
		int j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
