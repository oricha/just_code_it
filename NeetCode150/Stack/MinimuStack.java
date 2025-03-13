/**
 *
 */
import java.util.Stack;

/**
 * Minimum Stack
 * Design a stack that supports:
 * 1. Push an element onto the stack.
 * 2. Pop the top element from the stack.
 * 3. Retrieve the top element.
 * 4. Retrieve the minimum element in the stack in O(1) time.
 */

class MinimumStack {
    private Stack<Integer> stack;  // Main stack to store elements
    private Stack<Integer> minStack;  // Auxiliary stack to track the minimum value

    /**
     * Initializes the stack.
     */
    public MinimumStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param val The value to be pushed.
     */
    public void push(int val) {
        stack.push(val);

        // Push the minimum value onto minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Removes the top element from the stack.
     */
    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();

            // If the removed element is the minimum, pop from minStack as well
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    /**
     * Retrieves the top element of the stack.
     *
     * @return The top element.
     */
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    /**
     * Retrieves the minimum element in the stack.
     *
     * @return The minimum value in the stack.
     */
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        MinimumStack minStack = new MinimumStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        System.out.println("Min: " + minStack.getMin()); // Output: 3

        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Output: 3
        System.out.println("Min: " + minStack.getMin()); // Output: 3

        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // Output: 5
    }
}
/**
 Explanation of the Solution
 1.	Stack for Storage:
 •	A standard stack (stack) stores all pushed elements.
 •	A secondary minStack maintains the minimum values.
 2.	Push Operation (O(1))
 •	Push value into stack.
 •	Push into minStack only if it’s smaller or equal to the current min.
 3.	Pop Operation (O(1))
 •	Remove from stack.
 •	If the removed value is the current min, remove it from minStack as well.
 4.	Top Operation (O(1))
 •	Simply return the top of stack.
 5.	Get Minimum Operation (O(1))
 •	Return the top of minStack, which always stores the current min.

 Time & Space Complexity:
 •	Time Complexity: O(1) for all operations.
 •	Space Complexity: O(n), where n is the number of elements in the stack.
 */