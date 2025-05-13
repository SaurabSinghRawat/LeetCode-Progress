class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] count = new long[26];
        

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        for (int step = 0; step < t; step++) {
            long[] next = new long[26];
            
            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z' becomes 'a' and 'b'
                    next[0] = (next[0] + count[25]) % MOD;
                    next[1] = (next[1] + count[25]) % MOD;
                } else {
                    next[i + 1] = (next[i + 1] + count[i]) % MOD;
                }
            }
            count = next;
        }
        
        // Sum up total characters after t transformations
        long total = 0;
        for (long val : count) {
            total = (total + val) % MOD;
        }
        
        return (int) total;
    }
}
