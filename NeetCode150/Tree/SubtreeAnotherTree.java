/**
 * Subtree of Another Tree
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
 * with the same structure and node values as subRoot, otherwise return false.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5], subRoot = [2,4,5]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
 * Output: false
 *
 * Constraints:
 * 0 <= The number of nodes in both trees <= 100.
 * -100 <= root.val, subRoot.val <= 100
 */

class SubtreeAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // Check if trees are identical at current node
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Recur for left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if ( root == null) return false;

        if( isSameTree2(root , subRoot)) return true;

        return isSubTree2( root.left, subRoot) || isSubTree2(root.right, subRoot);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        if ( p == null || q == null) return false;
        if ( p.val != q.val) return false
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);

    }
}

/**
 * Explanation:
 * The solution uses recursion to traverse the main tree (root) and checks if at any node,
 * the subtree matches the given subRoot using the helper function isSameTree.
 * If the current node's subtree matches, return true.
 * Otherwise, check recursively in the left and right subtrees.
 *
 * Time Complexity: O(n * m), where n is the number of nodes in the root tree and m is the number of nodes in subRoot.
 * - Each node in the root tree calls isSameTree, which takes O(m) in the worst case.
 *
 * Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
 */
