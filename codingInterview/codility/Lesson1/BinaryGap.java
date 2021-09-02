class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String binaryStr = Integer.toBinaryString(N);
        char[] charArr = binaryStr.toCharArray();
        int flag = -1;
        int max = 0;
        for (int i = 0; i < charArr.length; ++i) {
            if(charArr[i] == '1') {
                if (flag > -1) {
                    int temp = i - flag - 1;
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    flag = i;
                }
                flag = i;
            }
        }
        return max;
    }
}