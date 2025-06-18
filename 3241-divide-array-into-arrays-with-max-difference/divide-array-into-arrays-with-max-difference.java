import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] result = new int[n / 3][3];

        for (int i = 0; i < n; i += 3) {
            int min = nums[i];
            int mid = nums[i + 1];
            int max = nums[i + 2];

            if (max - min > k) return new int[0][];

            result[i / 3][0] = min;
            result[i / 3][1] = mid;
            result[i / 3][2] = max;
        }
        return result;
    }
}
