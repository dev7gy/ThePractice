/*
 (5, [1, 3, 1, 4, 2, 3, 5, 4]) return 6
 (3, [1, 2, 1]) return -1
 (2, [2,2]) return -1
 */
// O(N)
class  FrogRiverOne {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int[] count = new int[X];
        /* index 0: leef1, index 1 : leaf2
            count[i] = min second
        */
        for (int n = 0; n < count.length; n++) {
            count[n] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (count[A[i] - 1] < 0 || count[A[i] - 1] > i) {
                count[A[i] - 1] = i;
            }
            
        }
        
        int maxSecond = 0;
        for (int k = 0; k < count.length; k++) {
            // can't cross
            if (count[k] < 0) {
                return -1;
            }
            if (maxSecond < count[k]) {
                maxSecond = count[k];
            }
        }
        return maxSecond;
    }
}