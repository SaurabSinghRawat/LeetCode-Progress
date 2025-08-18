class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = (double) cards[i];
        }
        return backtrack(nums);
    }

    private boolean backtrack(double[] nums) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs(nums[0] - TARGET) < EPSILON;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next[idx++] = nums[k];
                    }
                }

                for (double val : compute(nums[i], nums[j])) {
                    next[idx] = val;
                    if (backtrack(next)) return true;
                }
            }
        }
        return false;
    }

    private double[] compute(double a, double b) {
        return new double[]{
            a + b,
            a - b,
            b - a,
            a * b,
            b != 0 ? a / b : Double.NaN,
            a != 0 ? b / a : Double.NaN
        };
    }
}
