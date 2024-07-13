package arrays;

import java.util.*;

public class NumberOfPairsWithGivenSum {

    public static void main(String[] args) {
        // {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        // https://www.naukri.com/code360/problems/number-of-pairs-with-given-sum_630509?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM&count=25&page=2&search=&company%5B%5D=American%2520Express&sort_entity=order&sort_order=ASC&customSource=studio_nav


        int[] arr = {1,5,7,1};
        int sum = 6;

        int count = 0;

        Map<Integer, Integer> hmp = new HashMap<>();


        for(int i=0;i<arr.length;i++) {

            int remaining = sum - arr[i];
            if(hmp.containsKey(remaining)) {
                count = count + hmp.get(remaining);
            }
            hmp.put(arr[i], hmp.getOrDefault(arr[i], 0)+1);
        }

        System.out.println(count);

    }
}
