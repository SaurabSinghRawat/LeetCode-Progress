class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] arr = new long[n + 1];
        arr[1] = 1;
        long share = 0, MOD = (long)1e9 + 7;
        for (int t = 2; t <= n; t++) {
            if (t - delay > 0) share = (share + arr[t - delay] + MOD) % MOD;
            if (t - forget > 0) share = (share - arr[t - forget] + MOD) % MOD;
            arr[t] = share;
        }
        long know = 0;
        for (int i = n - forget + 1; i <= n; i++) know = (know + arr[i]) % MOD;
        return (int)know;
    }
}