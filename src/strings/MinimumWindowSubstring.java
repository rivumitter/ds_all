package strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        // https://leetcode.com/problems/minimum-window-substring/description/

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minimumWindowSubstring(s, t));
    }

    private static String minimumWindowSubstring(String s, String t) {

        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++)
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);

        int required = mapT.size();

        int l = 0, r = 0, created = 0;

        int[] ans = {-1, 0, 0};

        Map<Character, Integer> mapS = new HashMap<>();

        while (r < s.length()) {

            char c = s.charAt(r);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);

            if (mapT.containsKey(c) && mapT.get(c).equals(mapS.get(c)))
                created++;

            while (l<=r && created==required) {
                c = s.charAt(l);

                if(ans[0]==-1 || ans[0] > (r - l +1))
                {
                    ans[0] = (r-l) +1;
                    ans[1] = l;
                    ans[2] = r;
                }

                mapS.put(c, mapS.get(c) -1);
                if(mapT.containsKey(c) && mapS.get(c) < mapT.get(c)) {
                    created--;
                }
                l++;
            }
            r++;
        }

        if(ans[0] == -1)
            return "";

        return s.substring(ans[1], ans[2] +1);
    }
}
