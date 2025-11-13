class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // since 0 <= nums[i] <= 100
        int[] ans = new int[nums.length];
        
        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Prefix sum to get count of numbers smaller than current
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        // Build result
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return ans;
    }
}
