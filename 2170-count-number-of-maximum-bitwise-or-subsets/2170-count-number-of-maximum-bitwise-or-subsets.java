class Solution {
    int maxOr = 0, count = 0;
    
    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOr |= num;
        }
        dfs(nums, 0, 0);
        return count;
    }
    
    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }
        // Include nums[index]
        dfs(nums, index + 1, currentOr | nums[index]);
        // Exclude nums[index]
        dfs(nums, index + 1, currentOr);
    }
}
