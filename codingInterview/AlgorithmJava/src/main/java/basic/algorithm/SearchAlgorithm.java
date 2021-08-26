package basic.algorithm;

public class SearchAlgorithm {
    public int[] sortedArray = {1, 2, 3, 7, 9, 12, 21, 23, 27};

    public int binarySearch(int[] sortedArray, int num) {
        int index = -1;
        int startIndex = 0;
        int finishIndex = sortedArray.length - 1;

        // while low <= high
        for (int i = 0; i < sortedArray.length; i++) {
            int searchIndex = (startIndex + finishIndex) / 2;
            if (num > sortedArray[searchIndex]) {
                startIndex = searchIndex + 1;
            } else if (num < sortedArray[searchIndex]) {
                finishIndex = searchIndex - 1;
            } else {
                System.out.printf("count: %d", i + 1);
                return searchIndex;
            }
        }
        return index;
    }
}
