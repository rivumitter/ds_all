package greedy;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {

        // https://leetcode.com/problems/assign-cookies/description/

        int[] greed = {1,5,3,3,4};
        int[] sizeOfCookies = {4,2,1,2,1,3};


        System.out.println(maxCookiesAssigned(greed, sizeOfCookies));
    }

    private static int maxCookiesAssigned(int[] greed, int[] sizeOfCookies) {

        Arrays.sort(greed);
        Arrays.sort(sizeOfCookies);

        int l = 0,r = 0, n = greed.length, m = sizeOfCookies.length;

        while (l<m && r<n) {
            if(greed[r]<=sizeOfCookies[l]) {
                r++;
            }
            l++;
        }

        return r;
    }
}
