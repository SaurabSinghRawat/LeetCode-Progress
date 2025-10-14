class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        
        // Helper function to check if subarray [start, start + k - 1] is strictly increasing
        for (int i = 0; i + 2 * k <= n; i++) {
            boolean first = true, second = true;
            
            // Check first subarray nums[i..i+k-1]
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    first = false;
                    break;
                }
            }
            
            if (!first) continue; // skip if first is not increasing
            
            // Check second subarray nums[i+k..i+2k-1]
            for (int j = i + k + 1; j < i + 2 * k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    second = false;
                    break;
                }
            }
            
            if (second) return true;
        }
        
        return false;
    }
}
