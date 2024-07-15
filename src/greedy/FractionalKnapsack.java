package greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {

        // 8 10 2 1  10 7  1 7  9 5 7 1 2 8  6 6 4 8 9 7
        Item[] arr = {
                new Item(8, 10),
                new Item(2, 1),
                new Item(10, 7),
                new Item(1, 7),
                new Item(9, 5),
                new Item(7, 1),
                new Item(2, 8),
                new Item(6, 6),
                new Item(4, 8),
                new Item(9, 7),
        };

        int maxWeight = 21;

        System.out.println(maxValueFound(arr, maxWeight));

    }

    private static double maxValueFound(Item[] arr, int maxWeight) {

        Arrays.sort(arr, (o1, o2) -> {
            double frac1 = (double) o1.value / (double) o1.weight;
            double fract2 = (double) o2.value / (double) o2.weight;
            return Double.compare(fract2, frac1);
        });


        double maxValue = 0.0;

        for (Item item : arr) {
            if (maxWeight < item.weight) {
                maxValue = maxValue + (((double) item.value / (double) item.weight) * (double) maxWeight);
                break;
            } else {
                maxWeight = maxWeight - item.weight;
                maxValue += item.value;
            }
        }

        return maxValue;
    }
}

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
