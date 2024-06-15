package sliding_twopointer;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindowTwo {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1, 1, 1, 7, 8, 9};

        // https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

        long ans = maxSlidingWindow(arr, k);
        System.out.println("ans is:" + ans);
    }

    public static long maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;
        long ans = 0;
        long sum = 0;
        int n = nums.length;
        Set<Integer> integerSet = new HashSet<>();

        for(l=0;l<n;l++) {
            while (r<n && !integerSet.contains(nums[r]) && integerSet.size()<k) {
                integerSet.add(nums[r]);
                sum+=nums[r];
                r++;
            }
            if(integerSet.size()==k)
                ans = Math.max(sum, ans);
            sum = sum - nums[l];
            integerSet.remove(nums[l]);
        }
        return ans;
    }

}
