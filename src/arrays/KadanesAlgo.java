package arrays;

public class KadanesAlgo {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

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

        int start = -1, ansStart = -1, ansEnd = -1;

        for(int i=0;i<arr.length;i++) {
            if(sum == 0)
                start = i;
            sum+=arr[i];

            if(sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }

        for(int i=ansStart;i<=ansEnd;i++)
            System.out.print(arr[i] +" ");
    }
}
