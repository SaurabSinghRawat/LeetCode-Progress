class Solution {
    static final int MOD = 1_000_000_007;
    
    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        generateStates(new int[m], 0, states);
        
        Map<String, Integer> stateToIndex = new HashMap<>();
        for (int i = 0; i < states.size(); i++) {
            stateToIndex.put(Arrays.toString(states.get(i)), i);
        }

        int totalStates = states.size();
        List<Integer>[] transitions = new List[totalStates];
        for (int i = 0; i < totalStates; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < totalStates; j++) {
                if (isCompatible(states.get(i), states.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        int[] dp = new int[totalStates];
        Arrays.fill(dp, 1);

        for (int col = 1; col < n; col++) {
            int[] newDp = new int[totalStates];
            for (int i = 0; i < totalStates; i++) {
                for (int next : transitions[i]) {
                    newDp[next] = (newDp[next] + dp[i]) % MOD;
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp) {
            result = (result + val) % MOD;
        }
        return result;
    }

    private void generateStates(int[] current, int index, List<int[]> states) {
        if (index == current.length) {
            states.add(current.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (index > 0 && current[index - 1] == color) continue;
            current[index] = color;
            generateStates(current, index + 1, states);
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
