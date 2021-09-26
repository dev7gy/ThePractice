import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int biggestValue = A[A.length - 1];
        int tempBack;
        int tempFront = A[0] * A[1] * biggestValue;
        if (A.length > 3) {
             tempBack = biggestValue * A[A.length - 2] * A[A.length -3];
             if (tempBack > tempFront) {
                 return tempBack;
             }
        }
        return tempFront;
    }
}