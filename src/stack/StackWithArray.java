package stack;

public class StackWithArray {

    public int top;
    public int size;
    public int[] arr;

    public StackWithArray(int size) {
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    public void push(int num) {
        if(top==size-1) {
            throw new RuntimeException("size exceeded");
        }
        top++;
        arr[top] = num;
    }

    public int peek() {
        if(top==size-1) {
            throw new RuntimeException("size exceeded");
        } else if (top==-1) {
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }

    public int pop() {
        if (top==-1) {
            throw new RuntimeException("stack is empty");
        }
        int temp = arr[top];
        top--;
        return temp;
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
