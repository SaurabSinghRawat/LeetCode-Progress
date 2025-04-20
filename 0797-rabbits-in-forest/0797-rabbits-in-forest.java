import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int groupSize = entry.getKey() + 1;
            int numOfGroups = (int) Math.ceil((double) entry.getValue() / groupSize);
            totalRabbits += numOfGroups * groupSize;
        }

        return totalRabbits;
    }
}
