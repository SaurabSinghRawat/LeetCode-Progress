class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long count = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxFreq++;
            }

            // Shrink the window until max appears at least k times
            while (maxFreq >= k) {
                // If condition satisfied, all subarrays from left to right are valid
                count += nums.length - right;

                if (nums[left] == max) {
                    maxFreq--;
                }
                left++;
            }
        }

        return count;
    }
}
