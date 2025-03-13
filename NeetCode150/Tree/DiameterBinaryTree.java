/**
 * Diameter of Binary Tree
 * The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.
 *
 * The length of a path between two nodes in a binary tree is the number of edges between the nodes.
 *
 * Given the root of a binary tree root, return the diameter of the tree.
 *
 * Example 1:
 * Input: root = [1,null,2,3,4,5]
 *
 * Output: 3
 * Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].
 *
 * Example 2:
 * Input: root = [1,2,3]
 * Output: 2
 * Constraints:
 * 1 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
class DiameterBinaryTree {

    /**
     *
     📌 Space Complexity:
     •	O(H) where H is the height of the tree (for recursion stack in worst-case unbalanced trees).
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Create an array to store the maximum diameter encountered (single element array used to mutate value inside recursion)
        int[] diameter = new int[1];

        // Calculate the maximum depth while updating the diameter
        maxDepth(root, diameter);

        // Return the computed diameter
        return diameter[0];
    }

    /**
     * Helper function to compute the maximum depth of a tree while updating the diameter.
     *
     * @param node      The current node being processed.
     * @param diameter  An array storing the maximum diameter found so far.
     * @return The height of the current node.
     */
    private int maxDepth(TreeNode node, int[] diameter) {
        // Base case: if the node is null, return depth as 0
        if (node == null) {
            return 0;
        }

        // Recursively compute the height of left and right subtrees
        int leftHeight = maxDepth(node.left, diameter);
        int rightHeight = maxDepth(node.right, diameter);

        // Update the diameter (longest path between two leaf nodes)
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}