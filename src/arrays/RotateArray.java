package arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {7, 5, 2, 11, 2, 43, 1, 1};
        int k = 2;

        // left
        // https://www.naukri.com/code360/problems/rotate-array_1230543?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=SUBMISSION

        // right
        // https://leetcode.com/problems/rotate-array/description/



        rotateArrLeft(arr,k);
        for(int nums: arr)
            System.out.print(nums+" ");
    }

    private static void rotateArrRight(int[] arr, int k) {

        k = k % arr.length;

        int n = arr.length;

        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    private static void rotateArrLeft(int[] arr, int k) {

//        k = k % arr.length;

        int n = arr.length;

        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    static void reverse(int[] arr, int i, int j) {
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
