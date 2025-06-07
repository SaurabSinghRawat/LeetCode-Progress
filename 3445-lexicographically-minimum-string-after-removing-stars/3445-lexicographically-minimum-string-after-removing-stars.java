import java.util.*;

class Solution {
    public String clearStars(String s) {
        Deque<Integer>[] charIndices = new Deque[26];
        for (int i = 0; i < 26; i++) {
            charIndices[i] = new ArrayDeque<>();
        }

        int n = s.length();
        boolean[] toRemove = new boolean[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                toRemove[i] = true;
                for (int j = 0; j < 26; j++) {
                    if (!charIndices[j].isEmpty()) {
                        toRemove[charIndices[j].pop()] = true;
                        break;
                    }
                }
            } else {
                charIndices[ch - 'a'].push(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toRemove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
