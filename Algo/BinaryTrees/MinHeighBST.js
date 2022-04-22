/*
Write a function that takes in a non-empty sorted array of distinct integers, constructs a BST from the integers, 
and returns the root of the BST.
*/


// Time: O(n)
// Space: O(n)

function minHeightBst(array) {
    return helper(array, 0, array.length - 1);
}

function helper(array, startIdx, endIdx) {
    if (startIdx > endIdx) {
        return null;
    }

    const midIdx = Math.floor((startIdx + endIdx) / 2);
    const node = new BST(array[midIdx]);
    node.left = helper(array, startIdx, midIdx - 1);
    node.right = helper(array, midIdx + 1, endIdx);
    return node;
}

class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  insert(value) {
    if (value < this.value) {
      if (this.left === null) {
        this.left = new BST(value);
      } else {
        this.left.insert(value);
      }
    } else {
      if (this.right === null) {
        this.right = new BST(value);
      } else {
        this.right.insert(value);
      }
    }
  }
}

// Do not edit the line below.
exports.minHeightBst = minHeightBst;
