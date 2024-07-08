package sliding_twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplace {

    public static void main(String[] args) {

        String str = "BAAA";
        int k = 0;

        int ans = longestRepeatingCharReplace(str, k);
        System.out.println(ans);
    }

    private static int longestRepeatingCharReplace(String str, int k) {
        char[] arr = str.toCharArray();

        int ans = 0, l=0, r=0, len=0, n=arr.length, reqChange=0;
        Map<Character, Integer> hmp = new HashMap<>();


        while (r<n) {
            addFreq(hmp, arr[r]);
            len = (r-l) +1;
            reqChange = len - maxFreq(hmp);
            while (reqChange > k) {
                removeFreq(hmp, arr[l]);
                l++;
                len = (r-l) +1;
                reqChange = len - maxFreq(hmp);
            }
            ans = Math.max(ans, len);
            r++;
        }

        return ans;
    }

    static void addFreq(Map<Character, Integer> hmp, Character ch) {
        int count = hmp.getOrDefault(ch, 0);
        hmp.put(ch, count+1);
    }

    static void removeFreq(Map<Character, Integer> hmp, Character ch) {
        hmp.put(ch, hmp.get(ch)-1);
    }

    static int maxFreq(Map<Character, Integer> hmp) {
        int ans = Integer.MIN_VALUE;

        for(Map.Entry<Character, Integer> ks : hmp.entrySet()) {
            ans = Math.max(ans, ks.getValue());
        }

        return ans;
    }
}
