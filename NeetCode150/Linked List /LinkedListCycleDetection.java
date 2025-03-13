/**
 * Linked List Cycle Detection
 * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.
 *
 * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
 *
 * Note: index is not given to you as a parameter.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4], index = 1
 *
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 *
 * Input: head = [1,2], index = -1
 *
 * Output: false
 * Constraints:
 *
 * 1 <= Length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 * index is -1 or a valid index in the linked list.
 */
class LinkedListCycleDetection {

    /**
     * Using Floyd’s Cycle Detection Algorithm, also known as the Tortoise and Hare Algorithm.
     * @param head
     * @return
     */
   public boolean hasCycle(ListNode head) {
        // Use two pointers: slow moves one step, fast moves two steps
        ListNode slow = head, fast = head;

        // Traverse the list while fast and fast.next are not null
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow by 1 step
            fast = fast.next.next;  // Move fast by 2 steps

            // If slow and fast meet, a cycle exists
            if (slow == fast) return true;
        }
        // If fast reaches the end, there is no cycle
        return false;
    }
}
/**
 *Explanation of the Solution
 * 	1.	Use Floyd’s Cycle Detection Algorithm (O(n))
 * 	•	Treat the array as a linked list, where nums[i] points to nums[nums[i]].
 * 	•	Since n+1 elements are mapped to n distinct values, a cycle must exist.
 * 	•	Use Tortoise and Hare method to find the intersection point.
 * 	2.	Find the Entrance of the Cycle (O(n))
 * 	•	Reset slow to the start of the list.
 * 	•	Move both slow and fast one step at a time until they meet again.
 * 	•	The meeting point is the duplicate number.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n)
 * 	•	Space complexity: O(1)
 */