package sliding_twopointer;

public class GoldmanSachsCheckString {

    public static void main(String[] args) {


        // https://leetcode.com/discuss/interview-question/873022/goldman-sachs-interview-question-on-string


        String s = "aaabcbcbccb";
        String t = "abc";

        System.out.println(removeNadCheckString(s, t));
    }

    private static String removeNadCheckString(String s, String t) {


        String k = checkString(s, t);

        return k;
    }

    private static String checkString(String s, String t) {

        int sLen = s.length();
        int tLen = t.length(); // smaller one

        if(sLen< tLen)
            return s;

        for (int i=0;i<=s.length() - t.length(); i++) {
            StringBuilder str = new StringBuilder();

            if(s.substring(i, i+tLen).contentEquals(t)) {
                str.append(s, 0, i);
                str.append(s, i+tLen, sLen);
                System.out.println(str);
                return checkString(str.toString(), t);
            }
        }

        return s;
    }
}
