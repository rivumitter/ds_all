package stack;

class TwoStacks
{
    int[] arr;
    int top1;
    int top2;
    int size = 100;
    TwoStacks()
    {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }
    //Function to push an integer into the stack1.
    void push1(int x)
    {
        if(top1<top2 && top1<size)
        {
            top1++;
            arr[top1] = x;
        }
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
        if(top1<top2 && top2>=0) {
            top2--;
            arr[top2] = x;
        }
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1<top2 && top1!=-1) {
            int temp = arr[top1];
            top1--;
            return temp;
        }
        return -1;
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top1<top2 && top2!=size) {
            int temp = arr[top2];
            top2++;
            return temp;
        }
        return -1;
    }
}
