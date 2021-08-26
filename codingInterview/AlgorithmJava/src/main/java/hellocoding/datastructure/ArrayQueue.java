package hellocoding.datastructure;

import java.lang.reflect.Array;

public class ArrayQueue {
    private int[] queue;
    private int length;
    private int frontIndex;
    private int rearIndex;

    public ArrayQueue(int length) {
        this.queue = new int[length];
        this.frontIndex = -1;
        this.length = 0;
        this.rearIndex = -1;
    }

    public boolean isEmpty() {
        if (this.rearIndex == this.frontIndex - 1) {
            System.out.println("queue is FULL");
            return false;
        } else {
            return true;
        }
    }

    public void enqueue(int num) {
        this.rearIndex++;
        this.length++;
        this.frontIndex = (this.rearIndex + 1 - this.length) % this.queue.length;
        this.rearIndex = this.rearIndex % this.queue.length;
        this.queue[this.rearIndex] = num;
    }

    public void dequeue() {
        this.queue[this.frontIndex] = 0;
        this.frontIndex++;
        this.length--;
        this.frontIndex = this.frontIndex % this.queue.length;
    }

    public int[] getQueue() {
        return this.queue;
    }
}
