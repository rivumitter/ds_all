package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {2,7,11,15};
        int target = 9;

        int[] ans = twoSum(arr, target);
        for (int num : ans)
            System.out.println(num);

    }

    private static int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int k = 0;

        Map<Integer, Integer> hmp = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int rem = target - arr[i];
            if(hmp.containsKey(rem)) {
                ans[k++] = i;
                ans[k] = hmp.get(rem);
                return ans;
            }
            hmp.put(arr[i], i);
        }

        return ans;
    }
}
