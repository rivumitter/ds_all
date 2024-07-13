package arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubarrayWithSumK {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
        // {1,2,3,1,1,1,1,4,2,3} k = 3 {2. 0, 0, 3 } k = 3
        // zero sum too
        // https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany%5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum

        int[] arr = {15,-2,2,-8,1,7,10,23};

        int k = 0;

        int ans = maxLenSubarrayWithSumK(arr, k);

        System.out.println(ans);

    }

    // most optimised for negative and positive int
    private static int maxLenSubarrayWithSumK(int[] arr, int k) {

        int ans = 0, i = 0, n = arr.length, sum = 0, len = 0;

        Map<Integer, Integer> hmp = new HashMap<>();

        while (i < n) {
            sum = sum + arr[i];
            if (sum == k) {
                len = i + 1;
                ans = Math.max(ans, len);
            }
            int remaining = (sum - k);
            if (hmp.containsKey(remaining)) {
                len = (i - hmp.get(remaining));
                ans = Math.max(ans, len);
            }
            if (!hmp.containsKey(sum)) // for input 2,0,0,3 -> if sum as key exists  dont replace the value as we want the longest
                hmp.put(sum, i);
            i++;
        }

        return ans;
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
