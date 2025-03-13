/**
 * Balanced Binary Tree
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4]
 *
 * Output: true
 * Example 2:
 * Input: root = [1,2,3,null,null,4,null,5]
 * Output: false
 * Example 3:
 * Input: root = []
 * Output: true
 * Constraints:
 * The number of nodes in the tree is in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */
class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1; // If -1 is returned, the tree is unbalanced
    }

    // Helper method to check balance and return height
    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0; // Base case: Height of null node is 0
        }

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1; // If left subtree is unbalanced, propagate -1

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1; // If right subtree is unbalanced, propagate -1

        // If the height difference is greater than 1, return -1 to indicate imbalance
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }


    private int checkBalance2(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftHeight = checkBalance2(node.left);
        int rightHeight = checkBalance2(node.right);
        if( leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) >1 ){
            return -1;
        }
    }
}

/**
 * Solution Approach
 *
 * We use recursion to check the balance at each node while also calculating the height of subtrees.
 *
 * Key Idea
 * 	1.	Use a helper function (checkBalance) that:
 * 	•	Returns the height of the subtree if it is balanced.
 * 	•	Returns -1 if it detects an unbalanced subtree.
 * 	2.	Base Case: If a node is null, return height 0.
 * 	3.	Recursive Case:
 * 	•	Recursively compute left and right subtree heights.
 * 	•	If either subtree is unbalanced (-1), propagate -1 upwards.
 * 	•	If the height difference is more than 1, return -1 (unbalanced).
 * 	•	Otherwise, return the height of the current node (1 + max(leftHeight, rightHeight)).
 *
 * Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node once.
 * Space Complexity: O(h), where h is the height of the binary tree. The recursion stack can grow up to the height of the tree.
 */