import java.util.Arrays;
/**
 * O(N) or O(N * log(N))
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length > 0) {
            Arrays.sort(A);
            int answer = 1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != answer) {
                return answer;
                }
                answer++;
            }
            return answer;
        }
        else {
            return 1;
        }
        
    }
}