


//        Write a function that takes in a Binary Search Tree (BST) and a target integer
//        value and returns the closest value to that target value contained in the BST.
//You can assume that there will only be one closest value.

import java.util.*;

class Program {
    //Average: 0(log(n)) time | 0(1) space
    //Worst: 0(n) time | O(1) space
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest){
        BST currentNode = tree;
        while (currentNode != null){
            if (Math.abs(target - closest) > Math.abs( target - currentNode.value)) {
                closest = currentNode.value;
            }
            if( target < currentNode.value) {
                currentNode = currentNode.left;
            } else if( target > currentNode.value){
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

