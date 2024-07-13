package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayGivenSum {

    public static void main(String[] args) {

        // https://leetcode.com/problems/subarray-sum-equals-k/description/

        int [] arr = {1, 2, 3 , -3 , 1, 1, 1, 4, 2 , -3};

        int k = 3;

        System.out.println(countSubarrayGivenSum(arr, k));


    }

    private static int countSubarrayGivenSum(int[] arr, int k) {

        int count = 0, n = arr.length, sum=0;

        Map<Integer, Integer> hmp = new HashMap<>();

        for (int i=0;i<n;i++) {
            sum = sum+ arr[i];
            // as there can be a same sum we found so increase the freq

            if(sum == k) {
                count++;
            }

            int remaining = sum - k;
            if(hmp.containsKey(remaining)) {
                count = count+ hmp.get(remaining);
            }
            // storing prefix sum
            putSumCount(hmp, sum);
        }

        return count;
    }

    private static void putSumCount(Map<Integer, Integer> hmp, int num) {
        Integer count = hmp.getOrDefault(num, 0);
        hmp.put(num, count+1);
    }
}
