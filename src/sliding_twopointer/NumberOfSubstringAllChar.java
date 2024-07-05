package sliding_twopointer;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringAllChar {

    public static void main(String[] args) {

        // https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
        String str = "bbacba";

        int ans = numberOfSubstringAllCharABC(str);
        System.out.println(ans);
    }

    private static int numberOfSubstringAllCharABC(String str) {
        int ans = 0, i=0;

        Map<Character, Integer> hmp = new HashMap<>();

        char[] strCharArray = str.toCharArray();

        while (i<strCharArray.length) {

            hmp.put(strCharArray[i], i);
            if(hmp.size()==3) {
                ans++;
                ans = ans + getMinIndexLength(hmp);
            }
            i++;
        }

        return ans;
    }

    private static int getMinIndexLength(Map<Character, Integer> hmp) {

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> en :hmp.entrySet()) {
            min = Math.min(min, en.getValue());
        }
        return min;
    }
}
