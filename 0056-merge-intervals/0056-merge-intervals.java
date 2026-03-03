import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) 
            return intervals;

        // Step 1: Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        
        int[] current = intervals[0];
        result.add(current);

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → move forward
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}