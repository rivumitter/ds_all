package sliding_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumEqualToZero {

    public static void main(String[] args) {

        // https://leetcode.com/problems/3sum/description/

        int[] arr = {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
        List<List<Integer>> ans = threeSumEqualToZero(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSumEqualToZero(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        int n = arr.length;

        for(int i=0;i<n;i++) {
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j = i +1;
            int k = n-1;

            while (j<k) {
                int tempSum = arr[i] + arr[j] + arr[k];
                if(tempSum>0) {
                    k--;
                } else if (tempSum < 0) {
                    j++;
                }
                else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j<k && arr[j-1]==arr[j]) j++;
                    while (j<k && arr[k+1]==arr[k]) k--;
                }
            }
        }

        return ans;
    }
}
