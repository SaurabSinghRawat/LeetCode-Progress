import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        long countPairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            int freqCount = freq.getOrDefault(current, 0);
            countPairs += freqCount;  
            freq.put(current, freqCount + 1);

           
            while (countPairs >= k) {
                result += nums.length - right;  
                int leftNum = nums[left];
                int leftFreq = freq.get(leftNum);
                countPairs -= (leftFreq - 1);  
                freq.put(leftNum, leftFreq - 1);
                left++;
            }
        }

        return result;
    }
}
