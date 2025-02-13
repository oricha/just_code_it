## Task 2 - Codility Problem

### Problem Statement
In the army, each soldier has an assigned rank. A soldier of rank X has to report to (any) soldier of rank X + 1. Many soldiers can report to the same superior. Write a function:

```java
class Solution { public int solution(int[] ranks); }
```

that, given an array `ranks` consisting of soldiers' ranks, returns the number of soldiers who can report to some superior.

### Examples:

#### Example 1
```java
ranks = [3, 4, 3, 0, 2, 2, 3, 0, 0]
// Expected Output: 5
```
Explanation:
- Three soldiers of rank 3 (`ranks[0]`, `ranks[2]`, `ranks[6]`) may report to a soldier of rank 4 (`ranks[1]`).
- Two soldiers of rank 2 may report to any soldier of rank 3.

#### Example 2
```java
ranks = [4, 2, 0]
// Expected Output: 0
```
Explanation: No soldier can report to a superior.

#### Example 3
```java
ranks = [4, 4, 3, 3, 1, 0]
// Expected Output: 3
```
Explanation:
- A soldier of rank 0 can report to a soldier of rank 1.
- Two soldiers of rank 3 can report to any soldier of rank 4.

### Assumptions:
- `N` is an integer within the range `[2..100,000]`.
- Each element of array `ranks` is an integer within the range `[0..1,000,000,000]`.

---

**Copyright Notice:**  
Copyright 2009-2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication, or disclosure prohibited.
