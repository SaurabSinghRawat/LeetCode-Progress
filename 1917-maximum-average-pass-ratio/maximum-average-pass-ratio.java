import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] cur = pq.poll();
            int pass = (int)cur[1] + 1;
            int total = (int)cur[2] + 1;
            double gain = ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += (double)cur[1] / (double)cur[2];
        }

        return sum / classes.length;
    }
}
