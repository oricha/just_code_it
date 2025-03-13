/**
 *Remove Node From End of Linked List
 * You are given the beginning of a linked list head, and an integer n.
 *
 * Remove the nth node from the end of the list and return the beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4], n = 2
 *
 * Output: [1,2,4]
 * Example 2:
 *
 * Input: head = [5], n = 1
 *
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 2
 *
 * Output: [2]
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
/**
 * Remove Node From End of Linked List
 * Given a linked list `head`, remove the `n`-th node from the end in `O(n)`.
 *
 * Example 1:
 * Input: head = [1,2,3,4], n = 2
 * Output: [1,2,4]
 *
 * Example 2:
 * Input: head = [5], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 2
 * Output: [2]
 */

class RemoveNodeFromEndLinkedList {
    /**
     * Removes the `n`-th node from the end of the list using two-pointer technique.
     *
     * @param head The head of the linked list.
     * @param n The position from the end.
     * @return The head of the modified list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        // Move `first` ahead by `n + 1` steps
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the `n`-th node
        second.next = second.next.next;

        return dummy.next;
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
        RemoveNodeFromEndLinkedList solution = new RemoveNodeFromEndLinkedList();

        // Example 1: [1,2,3,4], n = 2 -> [1,2,4]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.removeNthFromEnd(head1, 2);
        printList(head1); // Output: 1 -> 2 -> 4 -> null

        // Example 2: [5], n = 1 -> []
        ListNode head2 = new ListNode(5);
        head2 = solution.removeNthFromEnd(head2, 1);
        printList(head2); // Output: null

        // Example 3: [1,2], n = 2 -> [2]
        ListNode head3 = new ListNode(1, new ListNode(2));
        head3 = solution.removeNthFromEnd(head3, 2);
        printList(head3); // Output: 2 -> null
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