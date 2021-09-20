/**
 * TimeComplexity
*/
// O(N)
class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int answer = 0;
        while (X < Y) {
            X+=D;
            answer++;
        }
        return answer;
    }
}

// O(1)
class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int answer = (Y - X) / D;
        int check = (Y - X) % D;
        if (check != 0){
            return answer + 1;
        } else {
            return answer;
        }
    }
}