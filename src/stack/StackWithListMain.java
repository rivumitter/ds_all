package stack;

import java.util.ArrayList;
import java.util.List;

public class StackWithListMain {

    public static void main(String[] args) {
        StackWithList<Integer> stackWithList = new StackWithList<>();

        stackWithList.push(10);
        stackWithList.push(20);
        stackWithList.push(30);

        System.out.println(stackWithList.peek());
        System.out.println(stackWithList.pop());

        stackWithList.push(40);
        System.out.println(stackWithList.peek());

        stackWithList.pop();
        stackWithList.pop();
        stackWithList.pop();
      //  stackWithList.peek();


    }
}

class StackWithList<T> {

    List<T> integerList;

    StackWithList() {
        integerList = new ArrayList<>();
    }

    public void push(T num) {
        integerList.add(num);
    }

    public T pop() {
        if(integerList.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        T temp = integerList.get(integerList.size() -1);
        integerList.remove(integerList.size()-1);
        return temp;
    }

    public T peek() {
        if (integerList.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return integerList.get(integerList.size() -1);
    }

    public boolean isEmpty() {
        return integerList.isEmpty();
    }

    public int size() {
        return integerList.size();
    }
}
