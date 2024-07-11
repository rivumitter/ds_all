package sliding_twopointer;

public class CountBinarySubarrayOfGivenSum {

    public static void main(String[] args) {

        // https://leetcode.com/problems/binary-subarrays-with-sum/description/

        int[] arr = {1,0,1,0,1};

        int goal = 2;

        int lessThankGoal = countBinarySubarrayOfGivenSum(arr, goal);
        int lessThankGoalMinusOne = countBinarySubarrayOfGivenSum(arr, goal-1);
        System.out.println(lessThankGoal - lessThankGoalMinusOne);
    }

    private static int countBinarySubarrayOfGivenSum(int[] arr, int goal) {
        int count = 0, l = 0, r = 0, sum = 0;

        // check sum<=goal
        while (r < arr.length) {
            if (goal < 0)
                return 0;
            sum = sum + arr[r];
            while (sum > goal) {
                sum = sum - arr[l];
                l++;
            }
            count = count + (r - l) + 1;
            r++;
        }
        return count;
    }
}
