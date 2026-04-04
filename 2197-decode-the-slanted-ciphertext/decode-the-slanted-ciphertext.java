class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int len = encodedText.length();
        int cols = len / rows;

        char[][] mat = new char[rows][cols];

        // Fill matrix row-wise
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = encodedText.charAt(idx++);
            }
        }

        // Read diagonally
        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;

            while (r < rows && c < cols) {
                result.append(mat[r][c]);
                r++;
                c++;
            }
        }

        // Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}