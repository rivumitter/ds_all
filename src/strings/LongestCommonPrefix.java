package strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        // https://leetcode.com/problems/longest-common-prefix/description/

        String[] arr = {"flower","flow","flight"};

        //System.out.println("abc".indexOf("abc"));

        System.out.println(longestCommonPrefix(arr));
    }

    private static String longestCommonPrefix(String[] arr) {

        String pref = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(pref)!=0) {
                pref = new StringBuilder(pref).substring(0, pref.length() - 1);
            }
        }

        return pref;
    }
}
