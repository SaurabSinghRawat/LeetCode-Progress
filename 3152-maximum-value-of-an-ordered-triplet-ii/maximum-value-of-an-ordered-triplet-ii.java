public class Solution {
    public static long maximumTripletValue(int[] nums) { // Changed return type to long
        int n = nums.length;
        long maxVal = 0; // Use long to prevent overflow

        int maxLeft = nums[0];
        int[] maxRight = new int[n];

        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        for (int j = 1; j < n - 1; j++) {
            maxVal = Math.max(maxVal, (long) (maxLeft - nums[j]) * maxRight[j + 1]); // Cast to long
            maxLeft = Math.max(maxLeft, nums[j]);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7})); // Output: 77
        System.out.println(maximumTripletValue(new int[]{1,10,3,4,19})); // Output: 133
        System.out.println(maximumTripletValue(new int[]{1,2,3})); // Output: 0
        System.out.println(maximumTripletValue(new int[]{1000000,1,1000000})); // Output: 999999000000
    }
}
