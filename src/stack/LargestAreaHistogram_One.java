package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class LargestAreaHistogram_One {

    public static void main(String[] args) {

        int[] arr = {2,1,5,6,2,3};

        int ans  = getLargestArea(arr, arr.length);
        System.out.println(ans);
       // System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack <> ();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        print(leftSmall, leftSmall.length);
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }
        print(rightSmall, rightSmall.length);

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;

    }
    private static int getLargestArea(int[] arr, int n) {
        int result = 0;

        int[] ps = getPreviousSmaller(arr, n);
        print(ps, n);
        int[] ns = getNextSmaller(arr, n);
        print(ns, n);
        for(int i=0;i<n;i++) {
            int tempResult = (ns[i] - ps[i] + 1)*arr[i];
            result = Math.max(result, tempResult);
        }
        return result;
    }

    private static int[] getPreviousSmaller(int[] arr, int n) {
        int[] ans = new int[n];

        ArrayDeque<Integer> prevDeque = new ArrayDeque<>();

        ans[0] = 0;
        prevDeque.push(0);

        for(int i=1;i<n;i++) {

            while (!prevDeque.isEmpty() && arr[i]<=arr[prevDeque.peek()])
                prevDeque.pop();

            int temp = prevDeque.isEmpty() ? 0 : (prevDeque.peek() + 1); // +1 for left boundary
            ans[i] = temp;

            prevDeque.push(i);
        }

        return ans;
    }

    private static int[] getNextSmaller(int[] arr, int n) {
        int[] ans = new int[n];

        ArrayDeque<Integer> nextDeque = new ArrayDeque<>();

        ans[n-1] = n-1;
        nextDeque.push(n-1);

        for(int i=n-1;i>=0;i--) {

            while (!nextDeque.isEmpty() && arr[i]<=arr[nextDeque.peek()])
                nextDeque.pop();

            int temp = nextDeque.isEmpty() ? n-1 : (nextDeque.peek() -1); // -1 for right boundary
            ans[i] = temp;

            nextDeque.push(i);
        }

        return ans;
    }

    static void print(int[] arr, int n) {
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
