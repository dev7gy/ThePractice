/* 문제 설명
    1. N과 A[]가 주어진다. 정답 배열은 원소 값이 모두 0인 배열로 시작한다. answer[] = {0,0,0......,0};
    2. 1 <= A[i] <= N 인 경우에는 answer[A[i]-1]의 값을 증가시킨다. (A[i]가 나온 count를 세는것)
    3. A[i] == N + 1 인 경우엔 answer의 모든 값을 최대 count수로 맞춘다.
    4. 2번과 3번을 반복한 후 answer[]를 반환한다.
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

    // second commit, O(N+M) score: 100
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] answer = new int[N];
        int max = 0;
        // if A[K] = N + 1, record data
        int lastMax = 0;
        int lastMaxIndex = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                if (i > lastMaxIndex && answer[A[i] - 1] < lastMax) {
                    answer[A[i] - 1] = lastMax;
                }
                answer[A[i] - 1]++;
                int current = answer[A[i] - 1];
                if (current > max) {
                    max = current;  
                }
            } else if (A[i] == N + 1) {
                lastMax = max;
                lastMaxIndex = i;
            }
        }

        // after A loop
        for (int j = 0; j < answer.length; j++) {
            if (answer[j] < lastMax) {
                answer[j] = lastMax;
            }
        }
        return answer;
    }   
}

