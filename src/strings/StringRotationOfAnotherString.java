package strings;

public class StringRotationOfAnotherString {

    public static void main(String[] args) {

        String s1 = "abacd";
        String s2 = "cdaba";

        String temp = s1 + s1;

        if(temp.contains(s2))
            System.out.println("rotation");
        else
            System.out.println("NO");


    }
}
