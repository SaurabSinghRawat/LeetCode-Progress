class Solution {
    public int possibleStringCount(String word) {
        List<Integer> groupLengths = new ArrayList<>();
        List<Character> groupChars = new ArrayList<>();
        
        // Group same consecutive characters
        int n = word.length();
        int i = 0;
        while (i < n) {
            char ch = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == ch) {
                count++;
                i++;
            }
            groupChars.add(ch);
            groupLengths.add(count);
        }
        
        // Only one group can be shortened (or none)
        int total = 1;  // original word, no changes

        for (int j = 0; j < groupLengths.size(); j++) {
            int len = groupLengths.get(j);
            if (len > 1) {
                total += len - 1; // Possible shortened versions (keep at least one char)
            }
        }

        return total;
    }
}
