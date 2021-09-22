/*
consecutive: 연이은
represent: 대표하다
exceed: 초과하다.
0 동쪽, 1 서쪽
(동, 서)
*/
class Solution {
    // O(N^2) score 50
    public int solution(int[] A) {
        // write your code in Java SE 8
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == 1) {
                        answer++;
                    }
                }
            }
        }
        if (answer > 1000000000) {
            return -1;
        }
        return answer;
    }
 
    // O(N) fail
    public int solution(int[] A) {
        // write your code in Java SE 8
        int prefixSumsLength = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                prefixSumsLength++;
            }
        }
        int[] prefixSums = new int[prefixSumsLength];

        int p = -1;
        int count = 0;
        for (int j = 0; j < A.length; j++) {
            if(A[j] == 0) {
                p++;
                if (p > 0) {
                    prefixSums[p] = prefixSums[p-1];
                }
            } else {
                prefixSums[p]++;
            }
        }

        int answer = 0;
        for (int k = prefixSumsLength - 1; k > 0; k--) {
            answer += prefixSums[k] - prefixSums[k-1]; 
        }
        answer += prefixSums[prefixSumsLength - 1];
        if (answer > 1000000000) {
            return -1;
        }
        return answer;
    }
}