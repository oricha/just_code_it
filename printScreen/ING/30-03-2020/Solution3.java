public class Solution1 {

    public int solution(int[] A) {

        int max = A[0];
        int N = A.length;
        int result = 0;
        int k = 50000;
        for (int i = 0; i < N; i++)
            A[(A[i] % k)] += k;

        for (int i = 0; i < N; i++) {
            if (A[i] > max) {
                max = A[i];
                result = i;
            }
        }


        return result;
    }
}
