class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int start = 0;
        
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            
            // Shrink window if score is too large
            while (sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }
            
            // All subarrays ending at 'end' and starting from [start, end] are valid
            count += (end - start + 1);
        }
        
        return count;
    }
}
