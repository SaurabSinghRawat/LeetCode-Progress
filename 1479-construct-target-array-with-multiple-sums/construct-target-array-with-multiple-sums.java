import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int t : target) {
            total += t;
            pq.offer(t);
        }

        while (true) {
            int max = pq.poll();
            long rest = total - max;
            if (max == 1 || rest == 1) return true;
            if (rest == 0 || max <= rest) return false;

            long prev = max % rest;
            if (prev == 0) return false;

            total = rest + prev;
            pq.offer((int) prev);
        }
    }
}
