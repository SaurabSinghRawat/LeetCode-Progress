class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // even indices: 0, 2, 4, ...
        long oddPositions = n / 2;        // odd indices: 1, 3, 5, ...

        // 5 choices for even indices (0, 2, 4, 6, 8)
        // 4 choices for odd indices (2, 3, 5, 7)
        long result = (modPow(5, evenPositions, MOD) * modPow(4, oddPositions, MOD)) % MOD;
        return (int) result;
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) { // if exponent is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
