package arrays;

public class MajorityElement {

    public static void main(String[] args) {

        // https://leetcode.com/problems/majority-element/description/
        int[] arr = {6,5,5};

        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] arr) {
        int n = arr.length, count = 0, temp = -1;
        int k = (int) Math.floor((double) n / 2);

        for(int i=0;i<n;i++) {
            if(count==0) { // prev element cant be so start again
                temp = arr[i];
                count = 1;
            }
            else if(arr[i]==temp)
                count++;
            else
                count--;
        }

        int cnt = 0;

        for (int i=0;i<n;i++)
        {
            if(arr[i] == temp){
               cnt++;
            }
        }

        if(cnt>k)
            return temp;
        else
            return -1;
    }
}
