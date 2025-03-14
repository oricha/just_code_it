import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    /**
     * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example,
     * if left rotations are performed on array , then the array would become .
     * Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
     * <p>
     * Given an array  of  integers and a number, ,
     * perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
     *
     * @param a
     * @param d
     * @return
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int size = a.size();
        int index = d ;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = index; i < size; i++) {
            if (index == size) {
                index = 0;
            }
            result.add(a.get(i));
            index++;
        }

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}