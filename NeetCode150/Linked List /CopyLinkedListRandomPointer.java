/**
 *Copy Linked List with Random Pointer
 * You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
 *
 * Create a deep copy of the list.
 *
 * The deep copy should consist of exactly n new nodes, each including:
 *
 * The original value val of the copied node
 * A next pointer to the new node corresponding to the next pointer of the original node
 * A random pointer to the new node corresponding to the random pointer of the original node
 * Note: None of the pointers in the new list should point to nodes in the original list.
 *
 * Return the head of the copied linked list.
 *
 * In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
 *
 * Example 1:
 *
 *
 *
 * Input: head = [[3,null],[7,3],[4,0],[5,1]]
 *
 * Output: [[3,null],[7,3],[4,0],[5,1]]
 * Example 2:
 *
 *
 *
 * Input: head = [[1,null],[2,2],[3,2]]
 *
 * Output: [[1,null],[2,2],[3,2]]
 * Constraints:
 *
 * 0 <= n <= 100
 * -100 <= Node.val <= 100
 * random is null or is pointing to some node in the linked list.
 */
// Definition for a Node.
import java.util.HashMap;

/**
 * Copy Linked List with Random Pointer
 * Given a linked list where each node has a `random` pointer,
 * create a deep copy of the list (no original pointers should remain).
 *
 * Example 1:
 * Input: head = [[3,null],[7,3],[4,0],[5,1]]
 * Output: [[3,null],[7,3],[4,0],[5,1]]
 *
 * Example 2:
 * Input: head = [[1,null],[2,2],[3,2]]
 * Output: [[1,null],[2,2],[3,2]]
 */

class CopyLinkedListRandomPointer {
    /**
     * Creates a deep copy of a linked list with random pointers.
     *
     * @param head The head of the original linked list.
     * @return The head of the copied linked list.
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and interweave them into the original list
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val); // Create a cloned node
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next; // Move two steps forward
        }

        // Step 2: Assign random pointers to the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // Clone the random pointer
            }
            curr = curr.next.next; // Move two steps forward
        }

        // Step 3: Separate the cloned list from the original list
        Node dummy = new Node(0); // Dummy node for the new list
        Node copyCurr = dummy, oldCurr = head;

        while (oldCurr != null) {
            copyCurr.next = oldCurr.next; // Extract the cloned node
            oldCurr.next = oldCurr.next.next; // Restore the original list

            copyCurr = copyCurr.next;
            oldCurr = oldCurr.next;
        }

        return dummy.next; // Return the new list's head
    }

    /**
     * Helper function to print the linked list (for testing).
     */
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + ", " + (curr.random != null ? curr.random.val : "null") + "] -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        CopyLinkedListRandomPointer solution = new CopyLinkedListRandomPointer();

        // Example 1: [[3,null],[7,3],[4,0],[5,1]]
        Node head1 = new Node(3);
        head1.next = new Node(7);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(5);

        head1.random = null;
        head1.next.random = head1.next.next.next; // 7 -> 5
        head1.next.next.random = head1; // 4 -> 3
        head1.next.next.next.random = head1.next; // 5 -> 7

        Node copied1 = solution.copyRandomList(head1);
        printList(copied1); // Output: [[3,null],[7,3],[4,0],[5,1]]

        // Example 2: [[1,null],[2,2],[3,2]]
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        head2.random = null;
        head2.next.random = head2.next.next; // 2 -> 3
        head2.next.next.random = head2.next.next; // 3 -> 3

        Node copied2 = solution.copyRandomList(head2);
        printList(copied2); // Output: [[1,null],[2,2],[3,2]]
    }
}

/**
 * Definition for a Node.
 */
class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 *  Explanation of the Solution
 * 	1.	Clone Nodes and Insert into the Original List (O(n))
 * 	•	Create a duplicate node after each original node.
 * 	•	Example:
 * 	Original: 3 -> 7 -> 4 -> 5
 * Interweaved: 3 -> 3' -> 7 -> 7' -> 4 -> 4' -> 5 -> 5'
 *
 2.	Set Random Pointers (O(n))
 •	If curr.random is not null, set curr.next.random = curr.random.next.
 3.	Separate the Cloned List (O(n))
 •	Extract the cloned nodes to form a separate list.

 Complexity Analysis:
 	•	Time complexity: O(n)
 	•	Space complexity: O(1)
 */