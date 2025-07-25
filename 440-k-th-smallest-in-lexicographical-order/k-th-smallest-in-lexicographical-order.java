class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; // Start at '1'
        k--; // We start from the first number, so we need k-1 steps

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                
                curr++;
                k -= steps;
            } else {
                // Go to the first child
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
