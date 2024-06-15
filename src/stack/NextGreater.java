package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreater {

    public static void main(String[] args) {

        int[] arr = {6,2,5,4,1,5,6};

        int[] ans = printNextGreater(arr, arr.length);

        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println("-----------");
    }


    private static int[] printNextGreater(int[] arr, int n) {

        int[] ans = new int[n];

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        numStack.push(n-1);
        ans[n-1] = n;


        for(int i=n-2;i>=0;i--) {
            while (!numStack.isEmpty() && arr[i]<=arr[numStack.peek()]) {
                numStack.pop();
            }

            if(numStack.isEmpty())
                ans[i] = n;
            else
                ans[i] = numStack.peek();

            numStack.push(i);
        }

        return ans;
    }
}
