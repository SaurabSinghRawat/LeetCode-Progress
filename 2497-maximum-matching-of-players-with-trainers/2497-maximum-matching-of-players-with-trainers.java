import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0; // pointer for players
        int j = 0; // pointer for trainers
        int matches = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            } else {
                j++; // trainer too weak, try next one
            }
        }

        return matches;
    }
}