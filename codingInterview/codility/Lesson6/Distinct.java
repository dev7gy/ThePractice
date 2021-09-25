import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        } 
        return set.size();
    }
}