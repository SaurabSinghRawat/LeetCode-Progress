class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;

        // Step 1: Compute lengths of increasing sequences ending at each index
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Step 2: Compute lengths of increasing sequences starting at each index
        int[] start = new int[n];
        start[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                start[i] = start[i + 1] + 1;
            } else {
                start[i] = 1;
            }
        }

        // Step 3: Find max k such that both adjacent subarrays of length k are strictly increasing
        int maxK = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = inc[i];       // length of increasing ending at i
            int right = start[i + 1]; // length of increasing starting at i+1
            maxK = Math.max(maxK, Math.min(left, right));
        }

        return maxK;
    }
}
