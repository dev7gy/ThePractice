//fail
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int count = 0;
        int lastIndex = 0;
        // Arrays.sort(A);
        while (lastIndex < A.length - 2) {
            for (int checkIndex = lastIndex; checkIndex < A.length - 2; checkIndex++) {
                if (A[checkIndex + 2] > A[checkIndex] + A[checkIndex + 1]) {
                    count += A.length - checkIndex;
                }
            }
            lastIndex++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 1, 8, 20};
        solution(arr);
    }
