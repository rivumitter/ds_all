package strings;

public class AllPermutation {

    public static void main(String[] args) {

        String str = "abc";

        printAllPerm(str, "");
    }

    private static void printAllPerm(String str, String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            String ls = str.substring(0,i);
            String rs = str.substring(i+1);
            String roq = ls + rs;
            printAllPerm(roq, asf+ch);
        }
    }
}
