import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> freqList = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                freqList.add(f);
            }
        }

        Collections.sort(freqList); 
        int minDeletions = Integer.MAX_VALUE;

        for (int baseFreq : freqList) {
            int deletions = 0;
            for (int f : freqList) {
                if (f < baseFreq) {
                    deletions += f; 
                } else if (f > baseFreq + k) {
                    deletions += f - (baseFreq + k);  
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
