
//You're given an array of integers where each integer represents a jump of its value in the array.
//For instance, the integer 2 represents a jump of two indices forward in the array; the integer -3 represents
//a jump of three indices backward in the array.
//If a jump spills past the array's bounds, it wraps over to the other side. For instance, a jump of -1 at index
//0 brings us to the last index in the array. Similarly, a jump of 1 at the last index in the array brings us to
//index 0.
//Write a function that returns a boolean representing whether the jumps in the array form a single cycle.
//A single cycle occurs if, starting at any index in the array and following the jumps, every element in
//the array is visited exactly once before landing back on the starting index.


import java.util.*;

class SingleCycleCheck {
    // O(n) time | O(1) space - where n is the length of the input array
    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIdx = 0;
        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIdx == 0) return false;
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    public static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
}
