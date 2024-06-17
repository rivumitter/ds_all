package sliding_twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWIthATmostKDistinct {

    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

        //String str = "aaabbccd";
        String str = "aabacbebebe";
        int k = 3;
//        int k = 5;

        int ans = longestSubstringDistinctK(str, k);
        System.out.println(ans);
    }

    private static int longestSubstringDistinctK(String str, int k) {

        int ans = 0;

        char[] arr = str.toCharArray();
        int l = 0,r=0,n = arr.length,count = 0;
        boolean isFound = false;

        Map<Character, Integer> hmp = new HashMap<>();

        while (r<n) {
            addToMap(hmp, arr[r]);
            if(hmp.size() == k)
                isFound = true;
            while (hmp.size() > k) {
                hmp.put(arr[l], hmp.get(arr[l]) -1);
                if(hmp.get(arr[l]) == 0) {
                    hmp.remove(arr[l]);
                }
                l++;
            }

            count = (r-l)+1;
            ans = Math.max(ans, count);
            r++;
        }

        if(isFound)
            return ans;
        else
            return -1;
    }

    private static void addToMap(Map<Character, Integer> hmp, char ch) {
        Integer count = hmp.getOrDefault(ch, 0);
        hmp.put(ch, count + 1);
    }
}
