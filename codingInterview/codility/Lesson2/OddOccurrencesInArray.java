import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap();
        int answer = -1;
        for(int i = 0; i < A.length; ++i) {
            if (map.containsKey(A[i])) {

                int count = map.get(A[i]);
                map.put(A[i], ++count);

            } else {
                map.put(A[i], 1);
            }
        }

        for( Integer key : map.keySet() ){
            if (map.get(key) % 2 == 1) {
                answer = key.intValue();
                break;
            }
        }
        return answer;
    }
}
