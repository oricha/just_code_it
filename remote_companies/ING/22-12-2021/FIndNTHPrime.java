

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/*
 Write a JAVA program to find the nth prime number.
 or Write a program to find the nth prime number using Java*
 N will be passed as Input of the function*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int solution(int[] ranks) {
        Map<Integer, Integer> rankCount = new HashMap<>();
        int reportableSoldiers = 0;

        // Count occurrences of each rank
        for (int rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        // Count soldiers who can report to a superior
        for (int rank : rankCount.keySet()) {
            if (rankCount.containsKey(rank + 1)) {
                reportableSoldiers += rankCount.get(rank);
            }
        }

        return reportableSoldiers;
    }
}
