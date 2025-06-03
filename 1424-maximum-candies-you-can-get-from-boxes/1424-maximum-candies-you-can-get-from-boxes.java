import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] hasKey = new boolean[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                visited[box] = true;
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            totalCandies += candies[curr];

            // Gain new keys
            for (int key : keys[curr]) {
                hasKey[key] = true;
                // If we now can open a box we already have and haven't visited it
                if (hasBox[key] && !visited[key] && status[key] == 0) {
                    status[key] = 1; // simulate unlocking
                    queue.offer(key);
                    visited[key] = true;
                }
            }

            // Gain new boxes
            for (int newBox : containedBoxes[curr]) {
                hasBox[newBox] = true;
                if (!visited[newBox] && (status[newBox] == 1 || hasKey[newBox])) {
                    if (status[newBox] == 0 && hasKey[newBox]) {
                        status[newBox] = 1;
                    }
                    queue.offer(newBox);
                    visited[newBox] = true;
                }
            }
        }

        return totalCandies;
    }
}
