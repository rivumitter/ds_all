package sliding_twopointer;

import java.util.HashSet;
import java.util.Set;

public class SlidingOne {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1,5,4,2,9,9,9};

        // variation good hard prob : https://leetcode.com/problems/sliding-window-maximum/description/
        // https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

        maxSlidingWindow(arr, k);
    }

    public static void maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        long ans = Long.MIN_VALUE;
        long sum = 0;
        int n = nums.length;
        Set<Integer> integerSet = new HashSet<>();




        for (int i = l; i <= r; i++) {
            sum += nums[i];
            integerSet.add(nums[i]);
        }
        if (integerSet.size() != k)
            System.out.println("final:" + 0);
        else {
            while (r < n - 1) {
                if (check(integerSet, l, r, nums) == k) {

                    sum = sum - nums[l];
                    l++;
                    r++;
                    sum = sum + nums[r];
                }
                else {
                    l++;
                    r++;
                }
                ans = Math.max(sum, ans);
                System.out.println(ans);
            }
            System.out.println("final:" + ans);

        }
    }

    private static int check(Set<Integer> integerSet, int l, int r, int[] nums) {
        integerSet.remove(nums[l]);
        integerSet.add(nums[r + 1]);
        return integerSet.size();
    }

}
