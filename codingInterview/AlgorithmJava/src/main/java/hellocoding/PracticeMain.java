package hellocoding;

import hellocoding.algorithm.SearchAlgorithm;
import hellocoding.datastructure.ArrayList;
import hellocoding.datastructure.LinkedList;
import hellocoding.datastructure.Node;

public class PracticeMain {

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
         *  - ArrrayList
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

        //ArrayList
        ArrayList aList = new ArrayList(10);
        for (int i = 0; i < 20; i += 2) {
            aList.insert(i);
        }
        aList.print();
        System.out.println(aList.search(4));
        aList.insertWithIndex(4, 2);
        aList.print();
        System.out.println(aList.delete(4));
        aList.print();

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
