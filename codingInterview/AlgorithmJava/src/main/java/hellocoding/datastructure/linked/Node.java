package hellocoding.datastructure.linked;

public class Node {
    private int value;
    private Node nextNode;

    public Node(final int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(final Node nextNode) {
        this.nextNode = nextNode;
    }
}
