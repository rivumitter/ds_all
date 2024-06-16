import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramJava8 {
    public static void main(String[] args) {

        String[] str = {"epam", "pame", "rivu","vuri", "arghya"};

        List<String> stringList = List.of("epam", "pame", "rivu", "vuri", "arghya");

        Map<String, List<String>> listMap =
                stringList.stream().collect(Collectors.groupingBy(GroupAnagramJava8::sortString));

        System.out.println(listMap.values());
    }

    private static String sortString(String s) {

        String[] split = s.split("");

        Arrays.sort(split);

        return Arrays.toString(split);
    }
}
