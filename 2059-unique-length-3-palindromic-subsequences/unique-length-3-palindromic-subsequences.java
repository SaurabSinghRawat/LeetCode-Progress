class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        // initialize positions
        java.util.Arrays.fill(first, -1);
        java.util.Arrays.fill(last, -1);

        // record first and last appearance of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int count = 0;

        // for each possible outer character
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] != -1 && last[c] > first[c]) {
                boolean[] seen = new boolean[26];
                // scan middle characters strictly between first and last
                for (int i = first[c] + 1; i < last[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                // count distinct middle characters
                for (boolean b : seen) {
                    if (b) count++;
                }
            }
        }
        return count;
    }
}
