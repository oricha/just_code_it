## Task 1 - Codility Problem

### Problem Statement
A six-sided die is a small cube with a different number of pips on each face (side), ranging from 1 to 6. On any two opposite sides of the cube, the number of pips adds up to 7; that is, there are three pairs of opposite sides: 1 and 6, 2 and 5, and 3 and 4.

There are N dice lying on a table, each showing the pips on its top face. In one move, you can take one die and rotate it to an adjacent face. For example, you can rotate a die that shows 1 so that it shows 2, 3, 4 or 5. However, it cannot show 6 in a single move, because the faces with one pip and six pips visible are on opposite sides rather than adjacent.

You want to show the same number of pips on the top faces of all N dice. Given that each of the dice can be moved multiple times, count the minimum number of moves needed to get equal faces.

### Function Signature
```java
class Solution {
    public int solution(int[] A);
}
```

### Example Inputs and Outputs
#### Example 1
```java
A = [1, 2, 3]
// Expected Output: 2
```
Explanation: You can pick the first two dice and rotate each of them in one move so that they all show three pips on the top face.

#### Example 2
```java
A = [1, 1, 6]
// Expected Output: 2
```
Explanation: The only optimal answer is to rotate the last die so that it shows one pip. This requires two rotations.

#### Example 3
```java
A = [1, 6, 2, 3]
// Expected Output: 3
```
Explanation: You can make all dice show 2 by rotating each die not showing 2 in one move.

### Assumptions
- `N` is an integer within the range `[1..100]`.
- Each element of array `A` is an integer within the range `[1..6]`.

---

**Copyright Notice:**  
Copyright 2009-2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication, or disclosure prohibited.
