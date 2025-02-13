## Pascal’s Triangle Problem

### Problem Statement
Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value `n`
as input and prints the first `n` lines of Pascal’s triangle. The following are the first 6 rows of Pascal’s Triangle:

```
      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1
 1 5 10 10 5 1
```

### Java Code for Pascal's Triangle

```java
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
}
```

### Explanation
- This program prints Pascal’s Triangle for `n = 5`.
- The function `factorial(n)` calculates the factorial of a number.
- The function `ncr(n, r)` calculates the binomial coefficient.
- The `main` function loops through the values and prints Pascal's Triangle in a formatted manner.

