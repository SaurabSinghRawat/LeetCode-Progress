class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; // Max sum of digits for n <= 9999 is 36 (9+9+9+9)
        
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
        }

        int maxSize = 0;
        for (int c : count) {
            maxSize = Math.max(maxSize, c);
        }

        int result = 0;
        for (int c : count) {
            if (c == maxSize) result++;
        }

        return result;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
