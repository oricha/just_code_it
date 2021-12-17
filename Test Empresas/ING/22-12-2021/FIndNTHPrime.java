

import java.util.Scanner;

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

    public static int nthPrime(int n) {
        int candidate, count;
        for(candidate = 2, count = 0; count < n; ++candidate) {
            if (isPrime(candidate)) {
                ++count;
            }
        }
        // The candidate has been incremented once after the count reached n
        return candidate-1;
    }
    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;

        int step = 4, m = (int)Math.sqrt(n) + 1;
        for(int i = 5; i < m; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(nthPrime( n));
        }
    }
}