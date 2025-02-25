/**
 * You are in charge of the cake for a child's birthday. It will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles.
 * Your task is to count how many candles are the tallest.
 *
 * Example
 *
 * The tallest candles are 4 units high. There are 2 candles with this height, so the function should return 2.
 *
 * Function Description
 *
 * Complete the function  with the following parameter(s):
 *
 * : the candle heights
 * Returns
 *
 * : the number of candles that are tallest
 * Input Format
 *
 * The first line contains a single integer, , the size of .
 * The second line contains  space-separated integers, where each integer  describes the height of .
 *
 * Constraints
 */
public class BirthDayCandle {
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {

        

    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
