package stack.striver;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SumOfSubarrayMin {

    public static void main(String[] args) {

        // https://leetcode.com/problems/sum-of-subarray-minimums/description/

        int[] arr = {11,81,94,43,3};

        System.out.println(sumOfSubarrayMin(arr));
    }

    // almost all will pass

    private static int sumOfSubarrayMin(int[] arr) {

        int n = arr.length;


        int[] prevSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];

        // prev

        Stack<Integer> st = new Stack<>();


        for(int i=0;i<n;i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();


        for(int i=n-1;i>=0;i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // now calculate ..

        int mod = (int) (Math.pow(10, 9) + 7);

        int sum = 0;
        for(int i=0;i<n;i++) {

            int left = i - prevSmaller[i];
            int right = nextSmaller[i] - i;
            sum = sum + (arr[i] * (int) (((long) left * right) % mod)) % mod;
        }
        return sum;
    }
}
