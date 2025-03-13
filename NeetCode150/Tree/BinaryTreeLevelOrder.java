/**
 * Binary Tree Level Order Traversal
 * Given a binary tree root, return the level order traversal of it as a nested list,
 * where each sublist contains the values of nodes at a particular level in the tree,
 * from left to right.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[1],[2,3],[4,5,6,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * 0 <= The number of nodes in the tree <= 1000.
 * -1000 <= Node.val <= 1000
 */

import java.util.*;

class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}

/**
 * Explanation:
 * The solution uses a breadth-first search (BFS) approach with a queue to traverse the tree level by level.
 * - We use a queue to store nodes and process them level by level.
 * - At each level, we extract all nodes, record their values, and enqueue their children.
 * - This process continues until all levels are processed.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
 * Space Complexity: O(n), as we store the nodes in a queue, with the maximum space being used at the last level of the tree.
 */
