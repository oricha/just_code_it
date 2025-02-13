import java.util.HashMap;
import java.util.Map;


public class DiceProblem {
    public int solution(int[] A) {
        int minMoves = Integer.MAX_VALUE;

        // Opposite faces mapping
        Map<Integer, Integer> opposite = new HashMap<>();
        opposite.put(1, 6);
        opposite.put(6, 1);
        opposite.put(2, 5);
        opposite.put(5, 2);
        opposite.put(3, 4);
        opposite.put(4, 3);

        // Try making all dice show face `target`
        for (int target = 1; target <= 6; target++) {
            int moves = 0;

            for (int die : A) {
                if (die == target) continue; // No move needed

                if (opposite.get(die) == target) {
                    moves += 2; // Rotating to opposite side takes two moves
                } else {
                    moves += 1; // Rotating to an adjacent face takes one move
                }
            }

            minMoves = Math.min(minMoves, moves);
        }

        return minMoves;
    }
}
