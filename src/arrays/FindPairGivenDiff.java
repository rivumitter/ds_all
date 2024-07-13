package arrays;

import java.util.Arrays;

public class FindPairGivenDiff {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1

        int[] arr = {5, 20, 3, 2, 5, 80};

        int x = 2;

        System.out.println(findPairGivenDiff(arr, x));
    }

    private static int findPairGivenDiff(int[] arr, int x) {

        Arrays.sort(arr);

        int s = 0,e=1, n = arr.length;
        while (s<n && e<n) {
            int diff = arr[e] - arr[s];
            if(s!=e && diff == x)
                return 1;
            else if (diff<x) {
                e++;
            }
            else
                s++;
        }

        return -1;
    }
}
