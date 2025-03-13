/**
 * Add Two Numbers
 * You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
 *
 * The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
 *
 * Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Return the sum of the two numbers as a linked list.
 *
 * Example 1:
 *
 *
 *
 * Input: l1 = [1,2,3], l2 = [4,5,6]
 *
 * Output: [5,7,9]
 *
 * Explanation: 321 + 654 = 975.
 * Example 2:
 *
 * Input: l1 = [9], l2 = [9]
 *
 * Output: [8,1]
 * Constraints:
 *
 * 1 <= l1.length, l2.length <= 100.
 * 0 <= Node.val <= 9
 */

/**
 * Add Two Numbers
 * Given two non-empty linked lists representing non-negative integers in reverse order,
 * return their sum as a linked list.
 *
 * Example 1:
 * Input: l1 = [1,2,3], l2 = [4,5,6]
 * Output: [5,7,9]
 * Explanation: 321 + 654 = 975.
 *
 * Example 2:
 * Input: l1 = [9], l2 = [9]
 * Output: [8,1]
 */

class AddTwoNumbers {
    /**
     * Adds two numbers represented as linked lists (reverse order).
     *
     * @param l1 The first linked list.
     * @param l2 The second linked list.
     * @return The sum represented as a linked list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result list handling
        ListNode current = dummy; // Pointer to construct the result
        int carry = 0; // Carry for addition

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Compute carry for next iteration
            current.next = new ListNode(sum % 10); // Store the current digit
            current = current.next;
        }

        return dummy.next; // Skip dummy node and return actual sum list
    }

    /**
     * Helper function to print a linked list (for testing).
     */
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: 321 + 654 = 975 -> [5,7,9]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        printList(result1); // Output: 5 -> 7 -> 9 -> null

        // Example 2: 9 + 9 = 18 -> [8,1]
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        printList(result2); // Output: 8 -> 1 -> null
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use a Dummy Node (O(1) Space)
 * 	•	A dummy node simplifies appending results and avoids handling special cases.
 * 	2.	Traverse Both Lists Simultaneously (O(max(n, m)))
 * 	•	Sum the corresponding digits.
 * 	•	Carry over any overflow to the next digit.
 * 	3.	Handle Carry (O(1))
 * 	•	If sum ≥ 10, store sum % 10 and carry sum / 10 to the next digit.
 * 	4.	Return the Constructed List
 * 	•	The resulting list represents the sum in reverse order.
 * 	•	Skip the dummy node and return the actual sum list.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(max(n, m))
 * 	•	Space complexity: O(1)
 */