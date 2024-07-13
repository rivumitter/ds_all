package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1

        int[] arr = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};

        System.out.println(longestConsecutiveSequence(arr));
    }

    // check if for every num if num -1 is there and so on
    private static int longestConsecutiveSequence(int[] arr) {
       int ans = 1, n = arr.length, count = 1;

        Set<Integer> ss = new HashSet<>();

        for(int nums : arr)
            ss.add(nums);

        for(int i=0;i<n;i++) {
            count = 1;
            int num = arr[i] - 1;
            while (ss.contains(num)) {
                count++;
                num--;
            }
            ans = Math.max(ans, count);
        }

       return ans;
    }
}
