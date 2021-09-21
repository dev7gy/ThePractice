/*

 
 */
class Solution {
    // first commit, O(N^2) score: 77
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] answer = new int[N];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                answer[A[i] - 1]++;
                int current = answer[A[i] - 1];
                if (current > max) {
                    max = current;  
                }
            } else if (A[i] == N+1) {
                for (int j = 0; j < answer.length; j++) {
                    answer[j] = max;
                }
            }
        }
        return answer;
    }
}

