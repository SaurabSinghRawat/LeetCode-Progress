import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build the DAG
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hamming(words[i], words[j]) == 1) {
                    graph[i].add(j);
                }
            }
        }

        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(next, -1);

        int maxLength = 0;
        int startIndex = 0;


        for (int i = 0; i < n; i++) {
            int len = dfs(i, graph, dp, next);
            if (len > maxLength) {
                maxLength = len;
                startIndex = i;
            }
        }

        // Reconstruct the path
        List<String> result = new ArrayList<>();
        while (startIndex != -1) {
            result.add(words[startIndex]);
            startIndex = next[startIndex];
        }
        return result;
    }

    private int dfs(int u, List<Integer>[] graph, int[] dp, int[] next) {
        if (dp[u] != -1) return dp[u];

        int maxLen = 1;
        int nextIdx = -1;

        for (int v : graph[u]) {
            int len = dfs(v, graph, dp, next);
            if (len + 1 > maxLen) {
                maxLen = len + 1;
                nextIdx = v;
            }
        }

        dp[u] = maxLen;
        next[u] = nextIdx;
        return dp[u];
    }

    private int hamming(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}
