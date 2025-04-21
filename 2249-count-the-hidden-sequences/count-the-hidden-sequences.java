class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0;
        long current = 0;

        for (int diff : differences) {
            current += diff;
            minPrefix = Math.min(minPrefix, current);
            maxPrefix = Math.max(maxPrefix, current);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        long result = maxStart - minStart + 1;
        return result < 0 ? 0 : (int) result;
    }
}
