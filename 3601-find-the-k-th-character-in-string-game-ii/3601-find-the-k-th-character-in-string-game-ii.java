class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Step 1: Calculate the length after all operations
        long[] lengths = new long[operations.length + 1];
        lengths[0] = 1; // initial word "a"

        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == 0) {
                lengths[i + 1] = lengths[i] * 2;
            } else {
                lengths[i + 1] = lengths[i] * 2;
            }
            if (lengths[i + 1] >= k) {
                // No need to go further
                lengths[i + 1] = k;
            }
        }

        // Step 2: Backtrack to find the actual character at position k
        int shift = 0; // Tracks the alphabet shift caused by op==1
        for (int i = operations.length - 1; i >= 0; i--) {
            long half = lengths[i];
            if (operations[i] == 0) {
                if (k > half) {
                    k = k - half; // Map back to first half
                }
                // else k remains
            } else {
                if (k > half) {
                    k = k - half; // It came from transformed part
                    shift++; // One character transformation step
                }
                // else k remains, no shift here
            }
        }

        // Now we’re back to the first character which is 'a'
        char result = (char) ('a' + shift % 26);
        return result;
    }
}
