package arrays;

public class RearrangeArray {

    public static void main(String[] args) {

        int[] arr = {3,1,-2,-5,2,-4};

        // https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

        int[] ans = rearrangeArray(arr);

        for(int num: ans)
            System.out.print(num+" ");

    }

    private static int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for(int i=0;i<n;i++) {
            if(arr[i] > 0) {
                ans[posIndex] = arr[i];
                posIndex = posIndex + 2;
            }
            else {
                ans[negIndex] = arr[i];
                negIndex = negIndex + 2;
            }
        }

        return ans;
    }
}
