/**
 * Lowest Common Ancestor in Binary Search Tree
 * Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q,
 * return the lowest common ancestor (LCA) of the two nodes.
 *
 * The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q
 * are descendants. The ancestor is allowed to be a descendant of itself.
 *
 * Example 1:
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8
 * Output: 5
 *
 * Example 2:
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 4
 * Output: 3
 * Explanation: The LCA of nodes 3 and 4 is 3, since a node can be a descendant of itself.
 *
 * Constraints:
 * 2 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 * p != q
 * p and q will both exist in the BST.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both p and q are greater than root, LCA must be in the right subtree
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If both p and q are smaller than root, LCA must be in the left subtree
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If p and q are on different sides or one is root, we found the LCA
            else {
                return root;
            }
        }
        return null;
    }
}

/**
 * Explanation:
 * Since this is a Binary Search Tree (BST), we leverage its properties to find the LCA efficiently.
 * - If both nodes are greater than the current node, we move to the right subtree.
 * - If both nodes are smaller than the current node, we move to the left subtree.
 * - Otherwise, the current node is the lowest common ancestor.
 *
 * Time Complexity: O(h), where h is the height of the BST. In a balanced BST, this is O(log n), but in the worst case (skewed tree), it is O(n).
 * Space Complexity: O(1), as we use only constant extra space.
 */
