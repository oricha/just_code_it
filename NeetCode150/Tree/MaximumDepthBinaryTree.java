/**
 * Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its depth.
 *
 * The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4]
 *
 * Output: 3
 * Example 2:
 *
 * Input: root = []
 *
 * Output: 0
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 */
class MaximumDepthBinaryTree {
    /**
     * Recursively determines the depth of the binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode root) {
        // Base case: If the tree is empty, return depth 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth plus 1 (for the current node)
        return 1 + Math.max(leftDepth, rightDepth);
    }
}