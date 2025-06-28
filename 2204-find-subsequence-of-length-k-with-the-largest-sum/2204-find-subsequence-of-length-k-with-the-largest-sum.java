import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); 

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }

        List<int[]> selected = new ArrayList<>(minHeap);
        selected.sort(Comparator.comparingInt(a -> a[1]));

        // Step 3: Extract values
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected.get(i)[0];
        }

        return result;
    }
}
