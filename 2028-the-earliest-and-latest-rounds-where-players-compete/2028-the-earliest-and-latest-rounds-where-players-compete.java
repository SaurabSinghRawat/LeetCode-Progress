import java.util.*;

class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) players.add(i);
        return dfs(players, 1, firstPlayer, secondPlayer);
    }

    private int[] dfs(List<Integer> players, int round, int fp, int sp) {
        String key = players.toString();
        if (memo.containsKey(key + "-" + round)) return memo.get(key + "-" + round);

        int size = players.size();
        int i = 0, j = size - 1;

        // Check if fp vs sp in this round
        while (i < j) {
            int p1 = players.get(i), p2 = players.get(j);
            if ((p1 == fp && p2 == sp) || (p1 == sp && p2 == fp)) {
                return new int[]{round, round};
            }
            i++; j--;
        }

        Set<List<Integer>> nextRounds = new HashSet<>();
        getNext(players, 0, players.size() - 1, fp, sp, new ArrayList<>(), nextRounds);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (List<Integer> next : nextRounds) {
            int[] res = dfs(next, round + 1, fp, sp);
            min = Math.min(min, res[0]);
            max = Math.max(max, res[1]);
        }

        int[] result = new int[]{min, max};
        memo.put(key + "-" + round, result);
        return result;
    }

    private void getNext(List<Integer> players, int l, int r, int fp, int sp,
                         List<Integer> curr, Set<List<Integer>> results) {
        if (l > r) {
            List<Integer> copy = new ArrayList<>(curr);
            Collections.sort(copy);
            results.add(copy);
            return;
        }

        if (l == r) {
            curr.add(players.get(l));
            getNext(players, l + 1, r, fp, sp, curr, results);
            curr.remove(curr.size() - 1);
            return;
        }

        int a = players.get(l), b = players.get(r);

        if ((a == fp && b == sp) || (a == sp && b == fp)) return; // meeting already handled

        if (a == fp || b == fp) {
            curr.add(fp);
            getNext(players, l + 1, r - 1, fp, sp, curr, results);
            curr.remove(curr.size() - 1);
        } else if (a == sp || b == sp) {
            curr.add(sp);
            getNext(players, l + 1, r - 1, fp, sp, curr, results);
            curr.remove(curr.size() - 1);
        } else {
            // Either can win
            curr.add(a);
            getNext(players, l + 1, r - 1, fp, sp, curr, results);
            curr.remove(curr.size() - 1);

            curr.add(b);
            getNext(players, l + 1, r - 1, fp, sp, curr, results);
            curr.remove(curr.size() - 1);
        }
    }
}
