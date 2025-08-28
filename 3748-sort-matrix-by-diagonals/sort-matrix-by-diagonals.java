class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        // bottom-left including main diagonal → sort descending
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, n - 1, j, false);
        }
        
        // top-right (excluding main diagonal) → sort ascending
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true);
        }
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int r, int c, boolean asc) {
        int n = grid.length;
        List<Integer> diag = new ArrayList<>();
        
        int i = r, j = c;
        while (i < n && j < n) {
            diag.add(grid[i][j]);
            i++; j++;
        }
        
        if (asc) Collections.sort(diag);
        else diag.sort(Collections.reverseOrder());
        
        i = r; j = c;
        int k = 0;
        while (i < n && j < n) {
            grid[i][j] = diag.get(k++);
            i++; j++;
        }
    }
}
