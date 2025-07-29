class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] bitLastSeen = new int[32]; // Tracks the latest index where each bit was seen

        // Traverse from the end
        for (int i = n - 1; i >= 0; i--) {
            // Update the last seen index for every set bit in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    bitLastSeen[b] = i;
                }
            }

            // Find the farthest index we must go to maintain all bits
            int farthest = i;
            for (int b = 0; b < 32; b++) {
                if (bitLastSeen[b] > farthest) {
                    farthest = bitLastSeen[b];
                }
            }

            answer[i] = farthest - i + 1;
        }

        return answer;
    }
}
