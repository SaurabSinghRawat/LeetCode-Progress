class Solution {
public:
    const int MOD = 1e9 + 7;

    long long nCr(long long n, int r) {
        if (n < r) return 0;
        return n * (n - 1) / 2;
    }

    long long distributeCandies(int n, int limit) {
        // Total ways without any limit
        long long total = nCr(n + 2, 2);

        // Remove ways where one child gets > limit
        for (int i = 0; i < 3; ++i) {
            total -= nCr(n - (limit + 1) + 2, 2);
        }

        // Add back over-subtracted double over-limit cases
        for (int i = 0; i < 3; ++i) {
            total += nCr(n - 2 * (limit + 1) + 2, 2);
        }

        // Subtract triple over-limit if applicable
        total -= nCr(n - 3 * (limit + 1) + 2, 2);

        return max(0LL, total);
    }
};
