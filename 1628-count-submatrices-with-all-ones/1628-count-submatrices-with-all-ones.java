class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];
        
        // Build heights matrix (like histogram heights per column)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0) heights[i][j] = 0;
                else heights[i][j] = (i == 0 ? 1 : heights[i - 1][j] + 1);
            }
        }
        
        int total = 0;
        // For each row, use histogram technique
        for (int i = 0; i < m; i++) {
            total += countFromHistogram(heights[i]);
        }
        return total;
    }

    private int countFromHistogram(int[] row) {
        int n = row.length;
        int res = 0;
        java.util.Stack<Integer> st = new java.util.Stack<>();
        int[] sum = new int[n];
        
        for (int j = 0; j < n; j++) {
            while (!st.isEmpty() && row[st.peek()] >= row[j]) {
                st.pop();
            }
            
            if (!st.isEmpty()) {
                int prev = st.peek();
                sum[j] = sum[prev] + row[j] * (j - prev);
            } else {
                sum[j] = row[j] * (j + 1);
            }
            res += sum[j];
            st.push(j);
        }
        return res;
    }
}
