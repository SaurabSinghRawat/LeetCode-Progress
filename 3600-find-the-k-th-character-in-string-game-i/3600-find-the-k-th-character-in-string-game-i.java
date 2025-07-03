class Solution {
    public char kthCharacter(int k) {
        int shift = 0;

        while (k > 1) {
            // Find length of previous word: power of 2 less than k
            int len = 1;
            while (2 * len < k) {
                len *= 2;
            }

            if (k > len) {
                k = k - len;
                shift++;
            }
        }

        // All characters originate from 'a'
        return (char) ((('a' - 'a') + shift) % 26 + 'a');
    }
}
