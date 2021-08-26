package basic;

import basic.algorithm.SearchAlgorithm;
import basic.datastructure.ArrayQueue;
import basic.datastructure.ArrayStack;
import basic.datastructure.SequentailList;
import basic.datastructure.linked.LinkedList;
import basic.datastructure.linked.Node;

public class BasicPractice {

    public static void main(String[] args) {
        /**
         * SearchAlgorithm
         *
         * - binarySearch
         */
        SearchAlgorithm searchAlgorithm = new SearchAlgorithm();
        printArray(searchAlgorithm.sortedArray);
        // binarySearch
        System.out.printf("%sindex: %d %s", System.getProperty("line.separator")
                , searchAlgorithm.binarySearch(searchAlgorithm.sortedArray, 30)
                , System.getProperty("line.separator"));


        /**
         *  DataStructure
         *  - LinkedList
         *  - SequentialList
         */
        // LinkedList
        LinkedList lList = new LinkedList();
        for (int i = 0; i < 10; i += 2) {
            lList.insert(i);
        }
        lList.print();
        Node searchedNode = lList.search(4);
        System.out.printf("Search %d %s%s", searchedNode.getValue(), searchedNode, System.lineSeparator());
        System.out.printf("Delete %d%s", lList.delete(4), System.lineSeparator());
        searchedNode = lList.search(4);
        try {
            System.out.printf("Search %d %s%s", searchedNode.getValue(), searchedNode, System.lineSeparator());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lList.print();
            System.out.printf("Delete %d%s", lList.delete(8), System.lineSeparator());
            lList.print();
        }

        //SequentailList
        SequentailList aList = new SequentailList(10);
        for (int i = 0; i < 20; i += 2) {
            aList.insert(i);
        }
        aList.print();
        System.out.println(aList.search(4));
        aList.insertWithIndex(4, 2);
        aList.print();
        System.out.println(aList.delete(4));
        aList.print();

        /**
         * Stack
         *
         */
        ArrayStack arrayStack = new ArrayStack(6);
        for (int i = 1; i < 20; i+=2) {
            if (arrayStack.isEmpty()) {
                arrayStack.push(i);
            } else {
                break;
            }
        }
        System.out.printf("ArrayStack Length: %d", arrayStack.getLength());
        System.out.println();
        printArray(arrayStack.getStack());
        for (int i = 0; i < arrayStack.getLength() + 1; i++) {
            System.out.printf("ArrayStack POP: %d", arrayStack.pop());
        }
        System.out.println();
        printArray(arrayStack.getStack());
        System.out.printf("ArrayStack Length: %d", arrayStack.getLength());
        System.out.println();
        /**
        queue
         */
        ArrayQueue AQ = new ArrayQueue(5);
        for (int i = 0; i < 5; i++) {
            AQ.enqueue(i);
            AQ.dequeue();
        }
        printArray(AQ.getQueue());
        AQ.enqueue(14);
        AQ.dequeue();
        AQ.enqueue(17);
        AQ.dequeue();
        AQ.enqueue(19);
        printArray(AQ.getQueue());
    }

    private static void printArray(int[] array) {
        System.out.print("index: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.printf("%svalue: ", System.lineSeparator());
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d", array[i]);
        }
        System.out.println();
    }
}
