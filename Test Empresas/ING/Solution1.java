public class Solution1 {

    public static void main(String[] args) {
        //System.out.println(new Solution().solution(new int[]{3, 0, 1, 1, 4, 1, 1}));
        //System.out.println(new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(new Solution().solution(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public int solution(int[] A) {
        int max = 0;
        int[] beans = new int[A.length + 1];
        int ibean = 0;
        int head;
        int tail;
        int counter = 0;

        if (A.length > 0) {
            for (int i = 0; i < A.length; i++) {
                counter = 1;
                head = i;
                tail = A[i];
                if (head != tail) {
                    if (beans[head] != 0 || head == 0) {
                        beans[ibean++] = head;
                        beans[ibean++] = tail;
                        while (head != tail) {
                            tail = A[tail];
                            beans[ibean++] = tail;
                            counter++;
                        }
                    }
                }
                if (counter > max) {
                    max = counter;
                }
            }

        }

        return max;
    }
}
