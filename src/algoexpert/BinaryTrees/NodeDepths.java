package algoexpert.BinaryTrees;

import java.util.*;

/**
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth.
 * Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.
 * Each BinaryTree node has an integer value, a left child node, and a right child node.
 * Children nodes can either be BinaryTree nodes themselves or None / null.

 * Sample Input
 * tree =    1
 *        /     \
 *       2       3
 *     /   \   /   \
 *    4     5 6     7
 *  /   \
 * 8     9
 * Sample Output
 * 16
 * // The depth of the node with value 2 is 1.
 * // The depth of the node with value 3 is 1.
 * // The depth of the node with value 4 is 2.
 * // The depth of the node with value 5 is 2.
 * // Etc..
 * // Summing all of these depths yields 16.
 */

class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        int sumOfDepths = 0;
        List<Level> stack = new ArrayList<Level>();
        stack.add(new Level(root, 0));
        while (stack.size() > 0) {
            Level top = stack.remove(stack.size() - 1);
            BinaryTree node = top.root;
            int depth = top.depth;
            if (node == null) continue;
            sumOfDepths += depth;
            stack.add(new Level(node.left, depth + 1));
            stack.add(new Level(node.right, depth + 1));
        }
        return sumOfDepths;
    }

    static class Level {
        public BinaryTree root;
        int depth;

        public Level(BinaryTree root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
