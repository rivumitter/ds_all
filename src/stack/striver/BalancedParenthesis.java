package stack.striver;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String str = "()[{}()[]]";

        System.out.println(checkBalancedParenthisis(str));
    }

    private static boolean checkBalancedParenthisis(String str) {

        Stack<Character> st = new Stack<>();

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                st.push(arr[i]);
            } else {
                if (st.isEmpty()) return false; // if only closing
                if ((st.peek() == '(' && arr[i] == ')') ||
                        (st.peek() == '{' && arr[i] == '}') ||
                        (st.peek() == '[' && arr[i] == ']')
                ) {
                    st.pop();
                } else
                    return false;
            }
        }

        return st.isEmpty();
    }
}
