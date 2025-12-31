class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length, ans = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean[][] grid = new boolean[row][col];
            for (int i = 0; i < mid; i++) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                grid[r][c] = true; // water
            }

            java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
            boolean[][] vis = new boolean[row][col];

            for (int c = 0; c < col; c++) {
                if (!grid[0][c]) {
                    q.offer(new int[]{0, c});
                    vis[0][c] = true;
                }
            }

            boolean canCross = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                if (r == row - 1) {
                    canCross = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                        !grid[nr][nc] && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            if (canCross) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
