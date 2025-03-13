/**
 * Car Fleet
 * There are n cars traveling to the same destination on a one-lane highway.
 * You are given two arrays of integers position and speed, both of length n.
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 * Return the number of different car fleets that will arrive at the destination.
 * Example 1:
 * Input: target = 10, position = [1,4], speed = [3,2]
 *
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
 * Example 2:
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1
 * Output: 3
 * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
 *
 * Constraints:
 *
 * n == position.length == speed.length.
 * 1 <= n <= 1000
 * 0 < target <= 1000
 * 0 < speed[i] <= 100
 * 0 <= position[i] < target
 * All the values of position are unique.
 */
import java.util.Arrays;
import java.util.Stack;

/**
 * Car Fleet
 * Given a highway with `n` cars moving towards a destination at `target` miles,
 * return the number of car fleets that will arrive at the destination.
 *
 * Example 1:
 * Input: target = 10, position = [1,4], speed = [3,2]
 * Output: 1
 *
 * Example 2:
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 * Output: 3
 */

class CarFleet {
    /**
     * Determines the number of car fleets that will reach the destination.
     *
     * @param target   The destination position.
     * @param position The initial positions of the cars.
     * @param speed    The speed of each car.
     * @return The number of car fleets arriving at the destination.
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1) return 1; // Only one car means one fleet

        // Create a 2D array of car positions and their respective times to reach the target
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // Position
            cars[i][1] = (double) (target - position[i]) / speed[i]; // Time to reach target
        }

        // Sort cars by starting position in descending order (farthest car first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Use a stack to count fleets
        Stack<Double> stack = new Stack<>();

        for (double[] car : cars) {
            double time = car[1];

            // If a new car takes longer to reach the target than the one before it,
            // it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        CarFleet solution = new CarFleet();

        // Example 1
        int target1 = 10;
        int[] position1 = {1, 4};
        int[] speed1 = {3, 2};
        System.out.println(solution.carFleet(target1, position1, speed1)); // Output: 1

        // Example 2
        int target2 = 10;
        int[] position2 = {4, 1, 0, 7};
        int[] speed2 = {2, 2, 1, 1};
        System.out.println(solution.carFleet(target2, position2, speed2)); // Output: 3

        // Example 3
        int target3 = 12;
        int[] position3 = {10, 8, 0, 5, 3};
        int[] speed3 = {2, 4, 1, 1, 3};
        System.out.println(solution.carFleet(target3, position3, speed3)); // Output: 3
    }
}

/**
 * Explanation of the Solution:
 * The solution uses a stack to keep track of the time when each car reaches the target.
 * If a new car takes longer to reach the target than the one before it, it forms a new fleet.
 * 	1.	Calculate the Time for Each Car to Reach the Target
 * 	•	Compute the time it takes for each car to reach target:
 *
 * \text{time} = \frac{\text{target} - \text{position}[i]}{\text{speed}[i]}
 *
 * 	•	Store this information in a cars[][] array.
 * 	2.	Sort Cars by Position in Descending Order
 * 	•	Sorting ensures we process cars in order from farthest to nearest.
 * 	3.	Use a Stack to Count Car Fleets
 * 	•	If a car takes longer than the top of the stack, it forms a new fleet.
 * 	•	If a car catches up to an existing fleet, it merges into that fleet.
 * 	4.	Return the Size of the Stack
 * 	•	Stack stores the times of fleets.
 * 	•	Size of stack is the number of fleets.
 * 	5.	Time Complexity: O(n log n), where n is the number of cars.
 * 	6.	Space Complexity: O(n), where n is the number of cars.
 */