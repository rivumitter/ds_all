package sliding_twopointer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FruitIntoBasket {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1

        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        int noOfBasket = 2;

        int ans = maxFruit(arr, noOfBasket);

        System.out.println(ans);
    }

    private static int maxFruit(int[] arr, int noOfBasket) {
        int ans = 0;

        int n = arr.length, l = 0, r = 0, count = 0;

        Map<Integer, Integer> hmp = new LinkedHashMap<>();

        while (r < n) {
            addValue(hmp, arr[r]);
            while (hmp.size() > noOfBasket) {
                hmp.put(arr[l], hmp.get(arr[l]) -1);
                if (hmp.get(arr[l]) == 0) {
                    hmp.remove(arr[l]);
                }
                l++;
            }

            count = (r - l) + 1;
            ans = Math.max(ans, count);
            r++;
        }
        return ans;
    }

    private static void addValue(Map<Integer, Integer> hmp, int i) {
        Integer count = hmp.getOrDefault(i, 0);
        hmp.put(i, count + 1);
    }
}
