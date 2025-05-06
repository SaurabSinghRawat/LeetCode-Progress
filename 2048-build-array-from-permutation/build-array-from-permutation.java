class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        // Encode both old and new value in nums[i]
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

       
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}
