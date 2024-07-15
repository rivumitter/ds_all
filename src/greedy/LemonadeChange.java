package greedy;

public class LemonadeChange {

    public static void main(String[] args) {

        // https://leetcode.com/problems/lemonade-change/description/

        int[] arr = {5,5,10,10,20};

        System.out.println(isPossible(arr));
    }

    private static boolean isPossible(int[] arr) {

        int five = 0, ten = 0, twenty = 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] ==5)
            {
                five++;
            } else if (arr[i] == 10) {
                if(five > 0) {
                    ten++;
                    five--;
                }
                else
                    return false;
            }
            else {
                if(five > 0 && ten > 0)
                {
                    ten--;
                    five--;
                    twenty++;
                } else if (five >= 3) {
                    five -=3;
                    twenty++;
                }
                else
                    return false;
            }
        }

        return true;
    }
}
