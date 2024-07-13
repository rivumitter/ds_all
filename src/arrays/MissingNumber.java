package arrays;

public class MissingNumber {

    public static void main(String[] args) {

        // https://www.naukri.com/code360/problems/missing-number_6680467?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems


        int[] arr = {1,2,4,5};

        System.out.println(missingNum(arr, 5));
    }

    private static int missingNum(int[] arr, int N) {

        int sumN = (N*(N+1))/2;
        int sum = 0;

        for(int nums: arr) {
            sum+=nums;
        }

        return (sumN - sum);

    }
}
