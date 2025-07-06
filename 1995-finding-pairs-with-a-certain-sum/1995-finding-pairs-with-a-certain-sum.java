import java.util.*;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new HashMap<>();
        
        // Build frequency map for nums2
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        // Decrement old value in map
        int oldVal = nums2[index];
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }

        // Update nums2 and map
        nums2[index] += val;
        int newVal = nums2[index];
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int num1 : nums1) {
            int complement = tot - num1;
            count += freqMap.getOrDefault(complement, 0);
        }
        return count;
    }
}
