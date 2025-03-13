/**
 * Binary Tree Right Side View
 * You are given the root of a binary tree. Return only the values of the nodes
 * that are visible from the right side of the tree, ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 * Example 2:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,3,7]
 *
 * Constraints:
 * 0 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer lastNodeValue = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                lastNodeValue = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(lastNodeValue);
        }

        return result;
    }
}

/**
 * Explanation:
 * The solution uses a breadth-first search (BFS) approach with a queue to traverse the tree level by level.
 * - At each level, we process all nodes and store the last node's value (rightmost node at that level).
 * - This ensures we capture the right-side view of the tree.
 * - We add children nodes to the queue in left-to-right order to ensure the rightmost node is processed last.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
 * Space Complexity: O(n), due to the storage of nodes in the queue and the result list.
 */
