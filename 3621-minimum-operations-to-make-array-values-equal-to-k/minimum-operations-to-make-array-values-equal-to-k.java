import java.util.*;

public class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1; // can't increase numbers to k
        }

        Set<Integer> uniqueGreaterThanK = new HashSet<>();
        for (int num : nums) {
            if (num > k) uniqueGreaterThanK.add(num);
        }

        // The number of unique values greater than k is the answer
        return uniqueGreaterThanK.size();
    }
}
