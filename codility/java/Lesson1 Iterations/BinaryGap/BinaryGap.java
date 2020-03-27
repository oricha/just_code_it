public class BinaryGap {
    public int solution(int n) {
        int finalGap = 0;
        //1 is  0
        if (n == 1) {
            return 0;
        }
        //use the shortest way to convert to a binary representation
        char binaryArray[] = Integer.toBinaryString(n).toCharArray();
        int tempGap = 0;
        //the binary representation must start with 1 we continue counting the 0 while
        // we found a new one, and then return the longest binary gap
        // the binary numbers ending on 0 cant be counted because it should be 1 0000..1
        // to be a valid gap
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == '0') {
                tempGap++;
                continue;
            } else if (binaryArray[i] == '1') {
                if (tempGap > finalGap) finalGap = tempGap;
                tempGap = 0;
            }

        }
        return finalGap;
    }
}
