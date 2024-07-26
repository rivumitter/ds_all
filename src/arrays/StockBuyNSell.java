package arrays;

public class StockBuyNSell {

    public static void main(String[] args) {
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

        int[] arr = {7,1,5,3,6,4};

        System.out.println(stockBuyNSell(arr));
    }

    private static int stockBuyNSell(int[] arr) {

        int profit = 0, minSoFar = arr[0], n = arr.length;

        for(int i=1;i<n;i++) {
            int cost = arr[i] - minSoFar;
            profit = Math.max(profit, cost);
            minSoFar = Math.min(minSoFar, arr[i]);
        }
        return profit;
    }
}
