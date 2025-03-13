/**
 *Reorder Linked List
 * You are given the head of a singly linked-list.
 *
 * The positions of a linked list of length = 7 for example, can intially be represented as:
 *
 * [0, 1, 2, 3, 4, 5, 6]
 *
 * Reorder the nodes of the linked list to be in the following order:
 *
 * [0, 6, 1, 5, 2, 4, 3]
 *
 * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
 *
 * [0, n-1, 1, n-2, 2, n-3, ...]
 *
 * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
 *
 * Example 1:
 *
 * Input: head = [2,4,6,8]
 *
 * Output: [2,8,4,6]
 * Example 2:
 *
 * Input: head = [2,4,6,8,10]
 *
 * Output: [2,10,4,8,6]
 * Constraints:
 *
 * 1 <= Length of the list <= 1000.
 * 1 <= Node.val <= 1000
 */

/**
 * Reorder Linked List
 * Given the head of a singly linked list, reorder the nodes such that they follow the pattern:
 * [0, n-1, 1, n-2, 2, n-3, ...]
 *
 * Example 1:
 * Input: head = [2,4,6,8]
 * Output: [2,8,4,6]
 *
 * Example 2:
 * Input: head = [2,4,6,8,10]
 * Output: [2,10,4,8,6]
 */

class ReorderList {
    /**
     * Reorders a linked list in the required pattern in-place.
     *
     * @param head The head node of the linked list.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list (using slow & fast pointers)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Split the list into two halves

        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next, temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    /**
     * Reverses a linked list.
     *
     * @param head The head node of the linked list.
     * @return The new head of the reversed list.
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Helper function to print the linked list (for testing).
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
        ReorderList solution = new ReorderList();

        // Example 1: [2,4,6,8] -> [2,8,4,6]
        ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8))));
        solution.reorderList(head1);
        printList(head1); // Output: 2 -> 8 -> 4 -> 6 -> null

        // Example 2: [2,4,6,8,10] -> [2,10,4,8,6]
        ListNode head2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));
        solution.reorderList(head2);
        printList(head2); // Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
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
 * 	1.	Find the Middle of the List (O(n))
 * 	•	Use slow and fast pointers.
 * 	•	Slow moves one step, fast moves two steps.
 * 	•	When fast reaches the end, slow is at the middle.
 * 	2.	Reverse the Second Half (O(n))
 * 	•	Use iterative reversal (prev, curr, next pointers).
 * 	•	Reverse all nodes after the middle.
 * 	3.	Merge Two Halves (O(n))
 * 	•	Alternately merge nodes from both halves.
 * 	•	Compare the values of the two nodes.
 * 	•	If the value of node1 is smaller, it remains as the head of the merged list.
 * 	•	Recursively merge the remaining elements of node1 and node2.
 * 	•	Otherwise, if the value of node2 is smaller, it remains as the head of the merged list.
 * 	•	Recursively merge node1 and the remaining elements of node2.
 Complexity Analysis:
 * 	•	Time complexity: O(n)
 * 	•	Space complexity: O(1)
 */