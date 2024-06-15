package sliding_twopointer;

public class MaxConsicutiveOneByFlippingKZeros {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};

        int k = 3;

        int ans = maxConsicutiveOneByFlippingKZeros(arr, k);

        // https://leetcode.com/problems/max-consecutive-ones-iii/description/

        System.out.println(ans);
    }

    private static int maxConsicutiveOneByFlippingKZeros(int[] arr, int k) {

        int ans = 0;

        int n = arr.length;
        int l = 0, r = 0;

        int count = 0, zeroCount = 0;

        while (r<n) {
            if(arr[r] == 0) {
                zeroCount++;
            }
            while (zeroCount>k) {
                if(arr[l] == 0)
                    zeroCount --;
                l++;
            }
            count = (r-l) + 1;
            ans = Math.max(ans, count);
            r++;
        }

        return ans;
    }

}
