import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxLen = 0;


        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freqMap.get(key) + freqMap.get(key + 1));
            }
        }

        return maxLen;
    }
}
