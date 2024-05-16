// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//  1 - 2,3,4,5
//  2 - 1,3,4,6
//  3 - 1,2,5,6
//  4 - 1,2,6,5

//  [ 1, 6, 2, 3]
//  [ 1, 6, 2, 3]

class Solution {
    public int solution(int[] A) {

        int min_roll = Integer.MAX_VALUE;
        int roll_dice = 0;

        for( int pip : A){
            roll_dice = 0;
            for( int number: A){
                if( pip == number){
                    roll_dice += 0;

                } else if( pip + number == 7){
                    roll_dice += 2;

                }else {
                    roll_dice += 1;
                }
            }
            if(roll_dice < min_roll){
                min_roll = roll_dice;
            }
        }
        return min_roll;
    }
}
