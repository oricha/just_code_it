

/*Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value n
        as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.

 */

// Java code for Pascal's Triangle

import java.io.*;


class Program {

    // Function to generate Pascal's Triangle
    static void printPascalsTriangle(int n) {
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = scanner.nextInt();
        scanner.close();

        printPascalsTriangle(n);
    }
}