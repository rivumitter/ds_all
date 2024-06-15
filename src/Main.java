import stack.StackWithArray;

public class Main {
    public static void main(String[] args) {

        StackWithArray stackWithArray = new StackWithArray(10);

        stackWithArray.push(5);
        stackWithArray.push(15);
        stackWithArray.push(25);

        System.out.println(stackWithArray.peek());
        System.out.println(stackWithArray.pop());

        stackWithArray.push(35);
      //  stackWithArray.push(55);
        System.out.println(stackWithArray.peek());

        System.out.println(stackWithArray.size());
        System.out.println(stackWithArray.isEmpty());

        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.isEmpty());
      //  System.out.println(stackWithArray.pop());
    }
}