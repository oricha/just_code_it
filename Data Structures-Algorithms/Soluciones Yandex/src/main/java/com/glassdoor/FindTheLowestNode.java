package com.glassdoor;

import com.base.Node;

/**
 *  5
 * |  \
 * 4    8
 * |   |  \
 * 1   7   11
 *  \      |
 *  3      9
 *  |       \
 *  2        10
 * 
 */
public class FindTheLowestNode {
    public static Object[] findTheLowestNode(Node n, int level) {
        if (n == null) {
            return null;
        }

        Object[] left = findTheLowestNode(n.left, level + 1);
        Object[] right = findTheLowestNode(n.right, level + 1);
        if (left == null) {
            left = new Object[] {n, level};
        }

        if (right == null) {
            right = new Object[] {n, level};
        }

        int compare= Integer.compare((Integer)left[1], (Integer)right[1]);
        if (compare == 0 || compare < 0) {
            return right;
        }
        if (compare > 0) {
            return left;
        }
        return right;
    }

    public static Node lowest(Node n) {
        return (Node) findTheLowestNode(n, 0)[0];
    }

    public static void main(String[] args) {
        Node n = new Node(null, 5);
        n.add(4);
        n.add(1);
        n.add(3);
        n.add(2);
        n.add(8);
        n.add(7);
        n.add(11);
        n.add(9);
        n.add(10);
        n.add(0);
        n.add(-1);
        n.add(-5);

        System.out.println(lowest(n));
    }
}
