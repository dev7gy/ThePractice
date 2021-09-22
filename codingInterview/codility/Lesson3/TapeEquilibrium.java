class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int diff = Integer.MAX_VALUE;
        int tempSum = 0;
        for (int j = 0; j < A.length - 1; j++) {
            tempSum += A[j];
            int currentDiff = absoluteDiff(sum - tempSum - tempSum);
            if ( currentDiff < diff ) {
                diff = currentDiff;
            }
        }
        return diff;
    }
    private int absoluteDiff(int n) {
        if (n < 0) {
            return n * -1;
        } else {
            return n;
        }
    }
}
