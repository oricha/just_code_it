/**
 * Merge Two Sorted Linked Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
 *
 * The new list should be made up of nodes from list1 and list2.
 *
 * Example 1:
 *
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,5]
 *
 * Output: [1,1,2,3,4,5]
 * Example 2:
 *
 * Input: list1 = [], list2 = [1,2]
 *
 * Output: [1,2]
 * Example 3:
 *
 * Input: list1 = [], list2 = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The length of the each list <= 100.
 * -100 <= Node.val <= 100
 */
class MergeTwoSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base case: If list1 is null, return list2 (since there is nothing to merge from list1)
        if (list1 == null) {
            return list2;
        }
        // Base case: If list2 is null, return list1 (since there is nothing to merge from list2)
        if (list2 == null) {
            return list1;
        }

        // Compare the values of the two nodes
        if (list1.val < list2.val) {
            // If list1's value is smaller, it remains as the head of the merged list
            // Recursively merge the remaining elements of list1 and list2
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // If list2's value is smaller, it remains as the head of the merged list
            // Recursively merge list1 and the remaining elements of list2
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

/**
 *  Approach:
 * 	1.	Base Case: If either list is empty, return the other.
 * 	2.	Recursive Comparison: Compare the head nodes of list1 and list2:
 * 	•	Pick the smaller node.
 * 	•	Recursively merge the rest.
 * 	3.	Repeat Until One List is Exhausted.
 *
 * Time Complexity Analysis:
 * 	•	Each recursive call processes one node.
 * 	•	There are n + m nodes in total (where n and m are the lengths of list1 and list2).
 * 	•	Each node is visited once and merged into the final list.
 * 	•	O(n + m) total operations.
 *
 * Space Complexity:
 * 	•	Recursive approach: O(n + m) (due to function call stack).
 * 	•	Iterative approach: O(1) (no extra recursive calls).
 */