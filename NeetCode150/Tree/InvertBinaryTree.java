/**
 * Invert Binary Tree
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 *
 * Output: [1,3,2,7,6,5,4]
 * Example 2:
 *
 * Input: root = [3,2,1]
 *
 * Output: [3,1,2]
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 */
class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        // Base case: If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right subtrees
        root.left = right;
        root.right = left;

        // Return the modified root
        return root;
    }
}