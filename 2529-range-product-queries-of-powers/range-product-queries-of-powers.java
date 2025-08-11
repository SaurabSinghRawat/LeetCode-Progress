class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) powers.add(1 << i);
        }
        long[] prefix = new long[powers.size() + 1];
        prefix[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long res = prefix[r + 1] * modInverse(prefix[l], MOD) % MOD;
            ans[i] = (int) res;
        }
        return ans;
    }
    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }
    private long pow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
