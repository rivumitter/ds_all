package greedy;

import java.util.Arrays;

public class RearrangeChar {

    public static void main(String[] args) {

        // https://leetcode.com/problems/reorganize-string/description/

        // video : https://www.youtube.com/watch?v=wZENBuWh-C0&t=860s

        String str = "abbabbaaab";

        System.out.println(rerrangeString(str));
    }

    private static String rerrangeString(String str) {

        int[] freq = new int[26];

        for (int i=0;i<str.length();i++)
        {
            freq[str.charAt(i) - 'a']++;
        }

        int maxChar = 0, maxVal = 0;

        for (int i=0;i<26;i++)
        {
            if(freq[i] > maxVal) {
                maxVal = freq[i];
                maxChar = i;
            }
        }

        if(maxVal > (str.length()+1)/2)
            return "";

        int idx = 0;
        char[] res = new char[str.length()];

        while (freq[maxChar]-- > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx+=2;
        }

        for (int i=0;i<freq.length;i++) {

            while (freq[i] -- > 0)
            {
                if(idx >= str.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx+=2;
            }
        }


        return String.valueOf(res);
    }
}
