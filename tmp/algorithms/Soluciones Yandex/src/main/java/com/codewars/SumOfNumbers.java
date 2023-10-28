public class SumOfNumbers {

	public int GetSum(int a, int b) {
		int result = 0;
		if (a == b)
			return a;

		if (b < a) {
			int x = a;
			a = b;
			b = x;
		}
		
		for(int i = a; i <= b ; i++){
			result += i;
		}

		return result;
	}

}
