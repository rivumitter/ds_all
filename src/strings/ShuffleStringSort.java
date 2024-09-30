package strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShuffleStringSort {

    public static void main(String[] args) {

        String str = "rockslife";

        int[] sortIndices = {4, 5, 6, 7, 8, 0, 1, 2, 3};

        List<Holder> holderList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            holderList.add(new Holder(str.charAt(i), sortIndices[i]));
        }

        String collected = holderList.stream().sorted(Comparator.comparing(Holder::indices))
                .map(Holder::ch).map(String::valueOf).collect(Collectors.joining());

        System.out.println(collected);

    }
}

record Holder(Character ch, int indices) {
}
