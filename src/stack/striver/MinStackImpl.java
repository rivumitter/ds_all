package stack.striver;

import java.util.Stack;

public class MinStackImpl {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}

class StackPair {
    public int value;
    public int min;

    public StackPair(int value, int min) {
        this.value = value;
        this.min = min;
    }

    public int getValue() {
        return value;
    }
    public int getMin() {
        return min;
    }
}

class MinStack {

    public Stack<StackPair> stackPairs = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if(stackPairs.isEmpty())
            stackPairs.push(new StackPair(val, val));
        else {
            int min = stackPairs.peek().getMin();
            stackPairs.push(new StackPair(val, Math.min(min, val)));
        }
    }

    public void pop() {
        stackPairs.pop();
    }

    public int top() {
        return stackPairs.peek().getValue();
    }

    public int getMin() {
        return stackPairs.peek().getMin();
    }
}



