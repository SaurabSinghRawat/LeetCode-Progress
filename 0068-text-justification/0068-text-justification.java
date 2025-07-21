class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int lineLen = words[i].length();
            int j = i + 1;

            while (j < n && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line or single word line
            if (j == n || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                int totalSpaces = maxWidth - lineLen;
                int space = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    line.append(words[k]);
                    line.append(" ".repeat(space + (k - i < extra ? 1 : 0)));
                }
                line.append(words[j - 1]);
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
