class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String ans = "";

        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                built.add(w);
                if (w.length() > ans.length()) {
                    ans = w;
                }
            }
        }

        return ans;
    }
}
