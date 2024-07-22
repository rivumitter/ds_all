package arrays;

public class ModifyVariableName {

    public static void main(String[] args) {

        String str = "this_is_a_variable";

        System.out.println(modify(str));
    }

    private static String modify(String str) {

        String[] arr = str.split("_");

        StringBuilder result = new StringBuilder();

        result.append(arr[0]);
        for(int i=1;i<arr.length;i++) {
            String temp1 = arr[i].substring(0,1);
            String temp2 = arr[i].substring(1);
            result.append(temp1.toUpperCase());
            result.append(temp2);
        }

        return result.toString();
    }
}
