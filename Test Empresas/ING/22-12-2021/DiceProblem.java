public class DiceProblem {
    public static void main(String args[]){

        int[] A = {3,4,1,2,4,2,3,5,1,2,3,4,6,2,4,1,5,2};
        int roll_dice;
        int min_roll = 9999999;

        for (int pip : A) {
            roll_dice = 0;
            for (int number : A) {
                if (pip == number) {
                    roll_dice += 0;
                } else if (pip + number == 7) {
                    roll_dice += 2;
                } else {
                    roll_dice += 1;
                }
            }
            if (roll_dice < min_roll) {
                min_roll = roll_dice;
            }
        }

        System.out.println("Minimum Flip Count:" + min_roll);
    }
}