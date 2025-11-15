class Solution {

    public int[] leftmostBuildingQueries(int[] h, int[][] queries) {
        int n = h.length;

        // next greater to the right
        int[] nxt = new int[n];
        Arrays.fill(nxt, -1);

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] <= h[i]) st.pop();
            if (!st.isEmpty()) nxt[i] = st.peek();
            st.push(i);
        }

        // binary lifting table
        int LOG = 17; // because 2^16 = 65536 > 5e4
        int[][] jump = new int[LOG][n];
        for (int i = 0; i < n; i++) jump[0][i] = nxt[i];
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                int mid = jump[k - 1][i];
                jump[k][i] = (mid == -1 ? -1 : jump[k - 1][mid]);
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int qi = 0; qi < q; qi++) {
            int a = queries[qi][0];
            int b = queries[qi][1];

            if (a == b) {
                ans[qi] = a;
                continue;
            }

            int i = Math.min(a, b);
            int j = Math.max(a, b);
            int hi = h[a], hb = h[b];
            int need = Math.max(hi, hb);

            if (h[i] < h[j]) {
                ans[qi] = j;
                continue;
            }

            int cur = j;
            if (h[cur] > need) {
                ans[qi] = cur;
                continue;
            }

            for (int k = LOG - 1; k >= 0; k--) {
                int nx = jump[k][cur];
                if (nx != -1 && h[nx] <= need) {
                    cur = nx;
                }
            }

            int nx = nxt[cur];
            if (nx != -1 && h[nx] > need) ans[qi] = nx;
            else ans[qi] = -1;
        }

        return ans;
    }
}
