import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();

        // Step 1: Count differences
        for (int x : basket1) count.put(x, count.getOrDefault(x, 0) + 1);
        for (int x : basket2) count.put(x, count.getOrDefault(x, 0) - 1);

        List<Integer> excess = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;

        // Step 2: Identify excess elements and check for impossible cases
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (val % 2 != 0) return -1; // Cannot balance
            minElement = Math.min(minElement, key);

            // Only add elements where excess exists
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                excess.add(key);
            }
        }

        Collections.sort(excess);

        // Step 3: Pairwise minimum cost swaps
        long cost = 0;
        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minElement);
        }

        return cost;
    }
}
