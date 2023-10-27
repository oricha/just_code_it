package codility.java.CodilityInJava.timecomplexity;

/**
 * This is the solution for Time Complexity > TapeEquilibrium
 * <p>
 * This is marked as PAINLESS difficulty
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3}));
    }

    public int solution(int[] Array) {
        int leftSum = Array[0];
        int rightSum = 0;
        for (int x : Array) {
            rightSum += x;
        }
        rightSum -= leftSum;

        int diff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < Array.length - 1; i++) {
            leftSum += Array[i];
            rightSum -= Array[i];
            int currentDiff = Math.abs(leftSum - rightSum);
            if (diff > currentDiff) {
                diff = currentDiff;
            }
        }
        return diff;
    }
}
