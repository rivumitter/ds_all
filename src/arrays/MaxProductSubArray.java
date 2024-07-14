package arrays;

public class MaxProductSubArray {

    public static void main(String[] args) {

        // https://leetcode.com/problems/maximum-product-subarray/description/
        int[] arr = {-2,3,4,-1,0,-2,3,1,4,0,-4,6,-1,4};

        System.out.println(maxProduct(arr));
    }

    // one overflow bigint case will not pass but its okay
    private static int maxProduct(int[] arr) {

        int ans = 0, prefixMax = Integer.MIN_VALUE, suffixMax = Integer.MIN_VALUE;
        int n = arr.length;

        int pref = 1, suf = 1;

        for(int i=0;i<n;i++) {
            if(arr[i] == 0) {
                pref = 1;
                continue;
            }
            pref = pref * arr[i];
            prefixMax = Math.max(prefixMax, pref);
        }

        for(int i=n-1;i>=0;i--) {
            if(arr[i] == 0) {
                suf = 1;
                continue;
            }
            suf = suf * arr[i];
            suffixMax = Math.max(suffixMax, suf);
        }

        ans = Math.max(ans, Math.max(prefixMax, suffixMax));

        return ans;
    }
}
