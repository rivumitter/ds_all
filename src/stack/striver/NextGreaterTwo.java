package stack.striver;

import java.util.Stack;

public class NextGreaterTwo {

    public static void main(String[] args) {

        // https://leetcode.com/problems/next-greater-element-ii/description/
        int[] arr = {2,10,12,1,11};

        int[] ans = nextGreaterTwo(arr);

        for (int n : ans)
            System.out.print(n + " ");
    }

    private static int[] nextGreaterTwo(int[] arr) {

        int[] ans = new int[arr.length];
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for(int i=(2*n-1); i>=0;i--) {

            while (!st.empty() && arr[i%n] >= st.peek())
                st.pop();

            if(i<n) {
                ans[i] = st.empty() ? -1 : st.peek();
            }

            st.push(arr[i % n]);
        }

        return ans;
    }
}
