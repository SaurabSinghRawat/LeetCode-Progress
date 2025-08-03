class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] pos = new int[n];
        int[] amt = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            amt[i] = fruits[i][1];
        }

        int left = 0, right = 0, sum = 0, max = 0;
        while (right < n) {
            sum += amt[right];
            while (left <= right && !isReachable(pos[left], pos[right], startPos, k)) {
                sum -= amt[left++];
            }
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }

    private boolean isReachable(int left, int right, int start, int k) {
        int goLeftFirst = Math.abs(start - left) + (right - left);
        int goRightFirst = Math.abs(start - right) + (right - left);
        return Math.min(goLeftFirst, goRightFirst) <= k;
    }
}
