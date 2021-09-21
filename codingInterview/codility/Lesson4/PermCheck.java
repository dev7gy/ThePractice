/*
permutation 순열
[4,1,3,2] return 1;
[4,1,3] return 0;
*/
// O(N)
import java.util.*;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int answer = 1;
        int start = 1;
        for(int i = 0; i < A.length; i++){
            if (A[i] == start) {
                start++;
            } else {
                return 0;
            }
        }
        return answer;
    }
}