package arrays;

public class SortZeroOneTwo {

    public static void main(String[] args) {

        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};

        sortArr(arr);

        for (int num : arr)
            System.out.print(num);
    }

    private static void sortArr(int[] arr) {

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid<=high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1)
                mid++;
            else {
                swap(arr, mid, high);
                high--;
                if (arr[mid] == 0) {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
