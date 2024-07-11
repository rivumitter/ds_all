package arrays;

public class KadanesAlgo {

    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(mxSum(arr));
        printMaxSumSubArray(arr);
    }

    private static int mxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;

    }

    private static void printMaxSumSubArray(int[] arr) {
        int l = 0, r = 0, sum = 0, maxSum = Integer.MIN_VALUE;

        int i = -1, j = -1;

        while (r < arr.length) {
            sum = sum + arr[r];
            if (sum > maxSum) {
                maxSum = sum;
                i = l;
                j = r;
            }
            if (sum < 0) {
                sum = 0;
                l = r;
            }
            r++;
        }

        if (i != -1 && j != -1) {
            for (int a = i; a <= j; a++) {
                System.out.print(arr[a]+" ");
            }

        }
    }
}
