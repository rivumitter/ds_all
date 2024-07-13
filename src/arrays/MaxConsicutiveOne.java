package arrays;

public class MaxConsicutiveOne {
    public static void main(String[] args) {

        int[] arr = {0,1,0,1};

        // https://www.naukri.com/code360/problems/maximum-consecutive-ones_3843993?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=SUBMISSION



        System.out.println(maxConsicutiveOne(arr));

    }

    private static int maxConsicutiveOne(int[] arr) {

        int ans = 0, count = 0, l = 0, r = 0, n = arr.length;

        while (r<n) {
            count = 0;
            while (r<n && arr[r] == 1) {
                count++;
                r++;
            }
            ans = Math.max(ans, count);
            r++;
        }

        return ans;
    }
}
