//fail
public int solution(int[] A) {
    // write your code in Java SE 8
    Arrays.sort(A);
    
    int count = 0;
    for (int i = A.length -1; i >= 2; i--) {
        if (A[i] < A[i - 1] + A[i -2]) {
            count++;
        }
    }
    
    return count;
}