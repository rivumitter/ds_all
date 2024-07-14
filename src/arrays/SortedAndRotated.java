package arrays;

public class SortedAndRotated {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};

        System.out.println(checkSortedAndRotated(arr));
    }

    private static boolean checkSortedAndRotated(int[] arr) {

        int count = 0, n = arr.length;
        for(int i=0;i<n;i++) {
            if(arr[i] > arr[(i+1) % n])
                count++;
            if(count > 1)
                return false;
        }

        return true;
    }
}
