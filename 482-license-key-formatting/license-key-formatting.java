class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        // Remove dashes and convert to uppercase
        for (char c : s.toCharArray()) {
            if (c != '-') sb.append(Character.toUpperCase(c));
        }
        
        // If string is empty after cleaning
        if (sb.length() == 0) return "";
        
        StringBuilder res = new StringBuilder();
        int firstGroupLen = sb.length() % k;
        int index = 0;
        
        // First group (may be shorter)
        if (firstGroupLen > 0) {
            res.append(sb.substring(0, firstGroupLen));
            index = firstGroupLen;
        }
        
        // Remaining groups of length k
        while (index < sb.length()) {
            if (res.length() > 0) res.append('-');
            res.append(sb.substring(index, index + k));
            index += k;
        }
        
        return res.toString();
    }
}
