package stack.striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {

        // https://www.interviewbit.com/problems/nearest-smaller-element/

        List<Integer> arr = List.of(4, 5, 2, 10, 8);

        System.out.println(nearestSmaller(arr));
    }

    private static List<Integer> nearestSmaller(List<Integer> arr) {

        List<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for (int i=0;i<arr.size();i++) {
            while (!st.empty() && arr.get(i) <= st.peek())
                st.pop();
            ans.add(i, st.empty() ? -1 : st.peek());
            st.push(arr.get(i));
        }

        return ans;
    }
}
