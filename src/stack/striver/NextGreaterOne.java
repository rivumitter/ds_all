package stack.striver;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterOne {

    public static void main(String[] args) {

        int[] num1 = {2,4};
        int[] num2 = {1, 2, 3, 4};

        // https://leetcode.com/problems/next-greater-element-i/description/
        int[] ans = nextGreater(num1, num2);

        for (int n : ans)
            System.out.print(n + " ");
    }

    private static int[] nextGreater(int[] num1, int[] num2) {

        int[] ans = new int[num1.length];
        int[] temp = new int[num2.length];

        Map<Integer, Integer> hmp = new HashMap<>();
        for (int i = 0; i < num2.length; i++)
            hmp.put(num2[i], i);

        Stack<Integer> st = new Stack<>();
        st.push(num2[num2.length - 1]);
        temp[num2.length - 1] = -1; // last element

        for (int i = num2.length - 2; i >= 0; i--) {

            while (!st.empty() && num2[i] > st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                temp[i] = -1;
                st.push(num2[i]);
            }
            else {
                temp[i] = st.peek();
                st.push(num2[i]);
            }
        }

        int k = 0;

        for (int i=0;i<num1.length;i++) {
            int index = hmp.get(num1[i]);

            ans[k++] = temp[index];
        }

        return ans;
    }
}
