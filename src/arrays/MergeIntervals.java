package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        // https://leetcode.com/problems/merge-intervals/description/

        int[][] arr = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};

        int[][] ans = mergeIntervals(arr);

        for(int i=0;i<ans.length;i++) {
            for(int j=0;j<ans[0].length;j++)
                System.out.print(ans[i][j] +" ");
        }
        System.out.println();
    }

    private static int[][] mergeIntervals(int[][] arr) {

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        List<List<Integer>> li = new ArrayList<>();

        for (int i = 0; i<arr.length; i++) {
            int listSize = li.size();
            if(li.isEmpty() || li.get(listSize -1).get(1) < arr[i][0]) {
                li.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            else {
              li.get(listSize -1).set(1, Math.max(li.get(listSize -1).get(1), arr[i][1]));
            }
        }

        int[][] ans = new int[li.size()][2];

        int k = 0;
        for(int i = 0; i< li.size(); i++) {
            ans[k][0] = li.get(i).get(0);
            ans[k++][1] = li.get(i).get(1);
        }

        return ans;
    }
}
