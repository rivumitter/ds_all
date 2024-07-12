package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FormBiggestNum {

    public static void main(String[] args) {

        String[] arr = {"3","30","34","5","9"};

        System.out.println(formBiggestNum(arr));
    }

    private static String formBiggestNum(String[] arr) {
        Comparator<String> myCompare
                = (X, Y) -> (X + Y).compareTo(Y + X);

        // Sort the array using the custom comparator
        Arrays.sort(arr, myCompare.reversed());

        // Handle the case where all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted array
        StringBuilder result = new StringBuilder();
        for (String num : arr) {
            result.append(num);
        }

        return result.toString();
    }
}
