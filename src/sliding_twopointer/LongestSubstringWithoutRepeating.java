package sliding_twopointer;

import java.util.*;

public class LongestSubstringWithoutRepeating {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static void main(String[] args) {

        String str = "pwwkew";
        int ans = longestSubstringOptimised(str);
        System.out.println(ans);
    }

    private static int longestSubstringOptimised(String str) {

        if(str.isEmpty())
            return 0;

        int ans = 1;

        int l = 0,r=0;
        int count = 1;

        char[] arr = str.toCharArray();

        int n = arr.length;

        Map<Character, Integer> tempHmp = new LinkedHashMap<>();

        while (r<n) {
            if(tempHmp.containsKey(arr[r])) {
                if(tempHmp.get(arr[r]) >= l ) {
                    l = tempHmp.get(arr[r]) + 1;
                }
            }
            tempHmp.put(arr[r], r);
            count = (r - l) + 1;
            ans = Math.max(ans, count);
            r++;
        }

        tempHmp.forEach((k,v) -> System.out.print(k));
        System.out.println();
        return ans;

    }

    private static int longestSubstring(String str) {
        if(str.isEmpty())
            return 0;

        int ans = 1;

        int l = 0,r=0;
        int count = 1;

        char[] arr = str.toCharArray();

        int n = arr.length;

        Set<Character> tempSet = new HashSet<>();

        while (r<n) {
            while (tempSet.contains(arr[r])) {
                tempSet.remove(arr[l]);
                l++;
            }
            tempSet.add(arr[r]);
            count = (r - l) + 1;
            ans = Math.max(ans, count);
            r++;
        }

//        tempSet.forEach(System.out::print);
//        System.out.println();

        return ans;
    }
}
