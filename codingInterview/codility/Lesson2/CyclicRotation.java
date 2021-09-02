class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] changedArray = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            int temp = i + K;
            changedArray[temp % A.length] = A[i];
        }
        return changedArray;
    }
}