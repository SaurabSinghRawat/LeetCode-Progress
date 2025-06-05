class Solution {
    private int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character as its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build the result using the smallest equivalent character
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (find(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by smallest lex character
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (px < py) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
        }
    }
}
