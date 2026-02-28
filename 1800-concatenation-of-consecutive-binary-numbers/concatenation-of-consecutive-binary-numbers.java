class Solution {
    public int concatenatedBinary(int n) {

        long mod = 1_000_000_007L;
        long ans = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {

            // increase bit length when i is power of 2
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            ans = ((ans << bitLength) + i) % mod;
        }

        return (int) ans;
    }
}