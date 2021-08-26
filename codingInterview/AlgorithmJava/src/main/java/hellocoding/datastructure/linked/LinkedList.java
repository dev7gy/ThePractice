package hellocoding.datastructure.linked;

import hellocoding.datastructure.DataStructure;

public class LinkedList implements DataStructure {
    private Node head;
    private Node current;
    private Node before;
    private int length;

    public LinkedList() {
        this.head = null;
        this.current = null;
        this.before = null;
        this.length = 0;
    }

    public Node insert(final int num) {
        Node newNode = new Node(num);
        if (this.head == null) {
            this.head = newNode;
            this.current = newNode;
        } else {
            newNode.setNextNode(this.current.getNextNode());
            this.current.setNextNode(newNode);
            this.before = this.current;
            this.current = newNode;
        }
        this.length++;
        return newNode;
    }

    public void print() {
        System.out.println("LinkedList Print Length: " + this.length);
        this.current = this.head;
        while (this.current != null) {
            this.before = this.current;
            System.out.printf("%5d", this.current.getValue());
            this.current = this.current.getNextNode();
        }
        System.out.println();
    }

    public int delete(final int num) {
        this.current = this.head;
        while (this.current != null) {
            if (this.current.getValue() == num) {
                int deletedDate = this.current.getValue();
                this.before.setNextNode(this.current.getNextNode());
                this.length--;
                return deletedDate;
            }
            before = current;
            current = current.getNextNode();
        }
        return -1;
    }

    public Node search(int num) {
        Node answer = null;
        current = head;
        while (current != null) {
            if (current.getValue() == num) {
                return current;
            }
            before = current;
            current = current.getNextNode();
        }
        return answer;
    }
}

