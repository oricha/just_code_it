

/*Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value n
        as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.

 */

// Java code for Pascal's Triangle

import java.io.*;


class Program {

    static int factorial(int n) {
        int f;
        for(f = 1; n > 1; n--){
            f *= n;
        }
        return f;
    }
    static int ncr(int n,int r) {
        return factorial(n) / ( factorial(n-r) * factorial(r) );
    }

    public static void main(String args[]){
        System.out.println();
        int n, i, j;
        n = 5;

        for(i = 0; i <= n; i++) {
            for(j = 0; j <= n-i; j++){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print(" "+ncr(i, j));
            }
            System.out.println();
        }
    }

    for( int i= 4; i < 4)
}