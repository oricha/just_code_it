import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by Zion on 29/9/16.
 */
public class Day3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String ans="";

        // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
        if((n%2==1) ||( n > 5 && n < 21)){
            ans = "Weird";
        }
        else{
            ans = "Not Weird";
        }
        System.out.println(ans);
    }
}
