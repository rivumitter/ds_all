package arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        // https://leetcode.com/problems/next-permutation/description/

        int[] arr = {1,3,2};

        nextPermutation(arr);

        for (int num : arr)
            System.out.print(num + " ");
    }

    // correct soltn in leetcode fewn test cases are wrong
    private static void nextPermutation(int[] arr) {

        int i = arr.length - 2;

        if(arr.length == 1)
            return;
        if(arr.length == 2)
        {
            swap(arr, 0, 1);
            return;
        }

        while (i > 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i <= 0) {
            Arrays.sort(arr);
            return;
        }

        // we need to change the i and swap it with its next bigger element;
        int el = arr[i];

        int nextElIndex = -1, nextMin = Integer.MAX_VALUE;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > el) {
                if (arr[j] < nextMin) {
                    nextMin = arr[j];
                    nextElIndex = j;
                }
            }
        }

        swap(arr, i, nextElIndex);

        Arrays.sort(arr, i + 1, arr.length);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
