package stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class StockSpan {
    public static void main(String[] args) {

        int[] arr = {60,10,20,40,35,30,50,70,65};

        int[] ans = calculateStockSpan(arr, arr.length);
        for (int num : ans)
            System.out.print(num+" ");
    }

    private static int[] calculateStockSpan(int[] arr, int n) {

        int[] ans = new int[n];
        for(int i=0;i<n;i++)
            ans[i] = 1;

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        Map<Integer, Integer> indexMap = new HashMap<>(); // as I dont want to write custom push pop and maintain top pointer

        indexStack.push(0);
        indexMap.put(0, arr[0]);

        for(int i=1;i<n;i++) {

            while (!indexStack.isEmpty() && indexMap.get(indexStack.peek())<= arr[i]) { // ...&& arr[top] <= arr[i]
                indexStack.pop();
            }
            if(indexStack.isEmpty()) {
                ans[i] = i + 1;
            }
            else
                ans[i] = i - indexStack.peek();

            indexMap.put(i, arr[i]);
            indexStack.push(i);
        }

        return ans;
    }
}
