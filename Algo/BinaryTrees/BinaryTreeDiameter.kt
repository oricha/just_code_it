


import kotlin.math.max
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}
open class TreeInfo(diameter: Int, height: Int) {
    val diameter = diameter
    val height = height
}
// Average case: when the tree is balanced
// O(n) time | O(h) space - where n is the number of nodes in
// the Binary Tree and h is the height of the Binary Tree
fun binaryTreeDiameter(tree: BinaryTree): Int {
    return getTreeInfo(tree).diameter
}
fun getTreeInfo(tree: BinaryTree?): TreeInfo {
    if (tree == null) return TreeInfo(0, 0)
    val leftTreeInfo = getTreeInfo(tree.left)
    val rightTreeInfo = getTreeInfo(tree.right)
    val longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height
    val maxDiameterSoFar = max(leftTreeInfo.diameter, rightTreeInfo.diameter)
    val currentDiameter = max(longestPathThroughRoot, maxDiameterSoFar)
    val currentHeight = 1 + max(leftTreeInfo.height, rightTreeInfo.height)
    return TreeInfo(currentDiameter, currentHeight)
}
