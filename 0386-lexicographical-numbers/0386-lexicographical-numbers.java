class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10; // dive into the next level
            } else {
                if (curr >= n) curr /= 10; // backtrack if needed
                curr++;
                while (curr % 10 == 0) {
                    curr /= 10; // strip trailing zeros after backtrack
                }
            }
        }
        return result;
    }
}
