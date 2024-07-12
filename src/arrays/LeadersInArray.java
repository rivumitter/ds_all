package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LeadersInArray {

    public static void main(String[] args) {

        int[] arr = {63, 70, 80, 33, 33, 47, 20};

        System.out.println(leadersInArray(arr));
    }

    private static List<Integer> leadersInArray(int[] arr) {

        Set<Integer> ss = new LinkedHashSet<>();

        int n = arr.length, maxSoFar = Integer.MIN_VALUE;

        for (int i = n-1;i>=0;i--) {
            if(arr[i] > maxSoFar) {
                maxSoFar = arr[i];
                ss.add(arr[i]);
            }
        }
        // return in any format

        int[] temp = new int[ss.size()];
        int k = ss.size() - 1;
        for (Integer num : ss) {
            temp[k--] = num;
        }
        return Arrays.stream(temp).boxed().toList();
    }
}
