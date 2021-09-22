/*
[1, 3, 6, 4, 1, 2] return 5
[1, 2, 3] return 4
[-1, -3] return 1
[-1, 100000] return 1
*/

// O(N*log(N))
import java.util.*;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int answer = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] == answer) {
                answer++;
            } 
        }
        return answer;
    }
}