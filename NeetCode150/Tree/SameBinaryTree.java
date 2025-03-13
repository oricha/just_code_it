/**
 * Same Binary Tree
 * Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
 * Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 *
 * Output: true
 * Example 2:
 * Input: p = [4,7], q = [4,null,7]
 *
 * Output: false
 * Example 3:
 * Input: p = [1,2,3], q = [1,3,2]
 *
 * Output: false
 * Constraints:
 *
 * 0 <= The number of nodes in both trees <= 100.
 * -100 <= Node.val <= 100
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null, trees are equivalent at this branch.
        if (p == null && q == null) {
            return true;
        }
        // One of the nodes is null, trees are not equivalent.
        if (p == null || q == null) {
            return false;
        }
        // Check if the current nodes have different values.
        if (p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if( p == null && q == null ) return true;

        if( p == null || q == null ) return false;

        if( p.val != q.val ) return false;

        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}

/**
Explanation:
The solution uses a recursive approach to compare two binary trees. The function first checks if both nodes are null, which means that branch of the tree is equivalent.
 If only one of the nodes is null, the trees are not the same, so it returns false. If both nodes are non-null, it compares their values. Finally, it recursively checks the left and right subtrees.
Time Complexity: O(n), where n is the number of nodes in the tree, as every node is visited once.
Space Complexity: O(h) where h is the height of the tree, due to the recursion stack.
*/