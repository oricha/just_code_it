

//Find Successor
//Write a function that takes in a Binary Tree (where nodes have an additional pointer to their parent node) as well as
// a node contained in that tree and returns the given node's successor.
//
//A node's successor is the next node to be visited (immediately after the given node) when traversing its tree using
// the in-order tree-traversal technique. A node has no successor if it's the last node to be visited in the in-order
// traversal.
//
//If a node has no successor, your function should return None / null.
//
//Each BinaryTree node has an integer value, a parent node, a left child node, and a right child node. Children nodes
// can either be BinaryTree nodes themselves or None / null.


package com.algoexpert.program
// This is an input class. Do not edit.
open class BinaryTree(value:Int){
    var value=value
    var left:BinaryTree?=null
    var right:BinaryTree?=null
    var parent:BinaryTree?=null
}

// O(h) time | O(1) space - where h is the height of the tree
fun findSuccessor(tree: BinaryTree, node: BinaryTree): BinaryTree? {
    if (node.right != null) return getLeftmostChild(node.right!!)
    return getRightmostParent(node)
}
fun getLeftmostChild(node: BinaryTree): BinaryTree {
    var currentNode = node
    while (currentNode.left != null) {
        currentNode = currentNode.left!!
    }
    return currentNode
}
fun getRightmostParent(node: BinaryTree): BinaryTree? {
    var currentNode = node
    while (currentNode.parent != null && currentNode.parent!!.right == currentNode) {
        currentNode = currentNode.parent!!
    }
    return currentNode.parent
}
