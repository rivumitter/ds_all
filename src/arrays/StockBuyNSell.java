package arrays;

public class StockBuyNSell {

    public static void main(String[] args) {
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

        int[] arr = {7,1,5,3,6,4};

        System.out.println(stockBuyNSell(arr));
    }

    private static int stockBuyNSell(int[] arr) {

        int ans = 0, minSoFar = arr[0], n = arr.length;

        for (int i=1;i<n;i++) {
            minSoFar = Math.min(minSoFar, arr[i-1]);
            if(arr[i] - minSoFar >= 0) {
                ans = Math.max(ans, (arr[i] - minSoFar));
            }
        }

        return ans;
    }
}
