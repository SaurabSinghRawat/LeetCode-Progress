class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;

        // Keep appending 'a' until the length exceeds or equals 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if b is a substring after current or one more repetition
        if (sb.indexOf(b) != -1) return count;
        sb.append(a);
        if (sb.indexOf(b) != -1) return count + 1;

        // If still not found
        return -1;
    }
}
