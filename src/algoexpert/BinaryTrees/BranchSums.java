package algoexpert.BinaryTrees;
//    A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
//    branch is a path of nodes in a tree that starts at the root node and ends at
//    any leaf node.

import java.util.*;

class BranchSums {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<Integer>();
        calculateBranchSums(root, 0 , sums);
        return sums;
    }

    public static void calculateBranchSums(BinaryTree node, int runningSum , List<Integer> sums){
        if( node == null) return ;

        int newRunningSum = runningSum + node.value;
        if(node.left == null && node.right ==null){
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);

    }
}
