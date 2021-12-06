

import java.util.*;

//Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left node
//in the tree for its corresponding right node.
//Each BinaryTree node has an integer value, a left child node, and a right child node.
//Children nodes can either be BinaryTree nodes themselves or None / null.


import java.util.*;
import java.util.ArrayDeque;

class Program {
    public static void invertBinaryTree(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
        queue.addLast(tree);
        while (queue.size() > 0) {
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }

    private static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
