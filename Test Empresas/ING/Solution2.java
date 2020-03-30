public class Solution1 {


    public int solution(int A, int B) {

        int result = 0;

        int count = 0;

        for (int i = 1; i <= B; i++) {

            result = i * (i + 1);

            if (result >= A && result <= B) {

                count++;

            }

        }

        return count;

    }
}
