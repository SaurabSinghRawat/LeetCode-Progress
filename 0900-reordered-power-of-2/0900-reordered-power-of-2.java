class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = countDigits(n);
        for (int i = 0; i < 31; i++) {
            if (target.equals(countDigits(1 << i))) return true;
        }
        return false;
    }

    private String countDigits(int num) {
        char[] count = new char[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return new String(count);
    }
}
