/*
consecutive: 연이은
represent: 대표하다
exceed: 초과하다.
0 동쪽, 1 서쪽
(동, 서)
*/
import java.util.*;
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
 
    /*
    [0, 1] 1
    [1, 0] 0
    [1, 0, 1] 1
    [1, 0, 1, 1] 2
    [1, 0, 1, 1, 1, 0, 1] 5
    [0, 1, 0, 1, 0, 1] 6
    */
    // O(N) 
    public int solution(int[] A) {
        List<Integer> array = new ArrayList<Integer>(); 
        int before = -1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {   
                count = i - before - 1;
                if (array.size() > 0) {
                    array.add(count + array.get(array.size() - 1));
                } else if (array.size() == 0 && before >= 0) {                   
                    array.add(count);
                }
                before = i;
            }
        }

        if (A[A.length - 1] == 1 && before > -1) {
            count = A.length - before - 1;
            int temp = 0;
            if (array.size() > 0) {
                temp = array.get(array.size() - 1);
            }
            array.add(count + temp);
        }

        if (array.size() < 1) {
            return 0;
        }

        int answer = array.get(array.size() - 1);
        for (int j = 0; j < array.size() - 1; j++) {
            answer += array.get(array.size() - 1) - array.get(j);
            if (answer > 1000000000) {
                return -1;
            }
        }
        return answer;
    }
}