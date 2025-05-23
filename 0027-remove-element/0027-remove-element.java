class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next position to place a non-val element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k; // Return count of elements not equal to val
    }
}
