package hellocoding.datastructure;

public class ArrayStack {
    private int[] stack;
    private int topIndex;

    public ArrayStack(int length) {
        this.stack = new int[length];
        this.topIndex = -1;
    }
    public boolean isEmpty(){
        if (this.topIndex >= this.stack.length - 1) {
            System.out.println("Stack is FULL");
            return false;
        } else {
            return true;
        }
    }

    public void push(int data) {
        this.topIndex++;
        stack[this.topIndex] = data;
    }
    public int pop() {
        if (this.topIndex < 0) {
            return -1;
        }
        int output = stack[this.topIndex];
        stack[this.topIndex] = 0;
        this.topIndex--;
        return output;
    }
    public int peek() {
        return stack[this.topIndex];
    }

    public int getLength() {
        return this.topIndex + 1    ;
    }
    public int[] getStack() {
        return this.stack;
    }
}
