package sliding_twopointer;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubarrayWithSumK {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
        // {1,2,3,1,1,1,1,4,2,3} k = 3 {2. 0, 0, 3 } k = 3
        int[] arr = {1,2,3,1,1,1,1,4,3,3};

        int k = 6;

        int ans = maxLenSubarrayWithSumKTwoPointer(arr, k);

        System.out.println(ans);

    }
    // most optimised but wont work for negative number but will work for nums with zero
    private static int maxLenSubarrayWithSumKTwoPointer(int[] arr, int k) {
        int ans = 0, l = 0, r= 0, n = arr.length, sum = 0, len = 0;

        while (r<n) {
            sum = sum + arr[r];
            while (sum>k) {
                sum = sum - arr[l];
                l++;
            }
            if(sum == k) {
                len = (r - l) + 1;
                ans = Math.max(ans, len);
            }
            r++;
        }
        return ans;
    }
}
