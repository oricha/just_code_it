
package com.algoexpert.program

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}


// O(n) time | O(n) space - where n is the number of nodes in the Binary Tree
fun branchSums(root: BinaryTree): List<Int> {
    val sums = mutableListOf<Int>()
    calculateBranchSums(root, 0, sums)
    return sums
}
fun calculateBranchSums(node: BinaryTree?, runningSum: Int, sums: MutableList<Int>) {
    if (node == null) return
    val newRunningSum = runningSum + node.value
    if (node.left == null && node.right == null) {
        sums.add(newRunningSum)
        return
    }
    calculateBranchSums(node.left, newRunningSum, sums)
    calculateBranchSums(node.right, newRunningSum, sums)
}