package arrays;

import java.util.List;

public class SecondLargest {

    public static void main(String[] args) {

        List<Integer> li = List.of(1, 2, 10, 7, 7, 5, 9, 8, 6, 3,-1);

        System.out.println(secondLargest(li));
        System.out.println(secondSmallest(li));
    }

    private static int secondLargest(List<Integer> arr) {
        int first = arr.get(0), second = Integer.MIN_VALUE, n = arr.size();

        for(int i=1;i<n;i++) {
            if(arr.get(i) > first)
            {
                second = first;
                first = arr.get(i);
            } else if (arr.get(i) < first && arr.get(i) > second) {
                second = arr.get(i);
            }
        }

        return second;
    }

    private static int secondSmallest(List<Integer> arr) {
        int first = arr.get(0), second = Integer.MAX_VALUE, n = arr.size();
        for(int i=1;i<n;i++) {
            if(arr.get(i) < first)
            {
                second = first;
                first = arr.get(i);
            } else if (arr.get(i) > first && arr.get(i) < second) {
                second = arr.get(i);
            }
        }

        return second;
    }


}
