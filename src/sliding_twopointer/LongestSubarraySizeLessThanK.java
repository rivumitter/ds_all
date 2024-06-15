package sliding_twopointer;

public class LongestSubarraySizeLessThanK {
    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 10, 10};
        int k = 14;
        int ans = longestSubarraySize(arr, k);
        System.out.println(ans);
    }

    private static int longestSubarraySize(int[] arr, int k) {

        int ans = 0, len = 0;

        int n = arr.length;

        int l = 0, r = 0, sum = 0;

        while (r<n) {
            sum = sum + arr[r];
            while (sum>k) {
                sum = sum - arr[l];
                l++;
            }
            len = (r - l) + 1;
            ans = Math.max(ans, len);
            r++;
        }
        return ans;
    }
}
