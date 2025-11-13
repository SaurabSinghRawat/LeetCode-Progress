class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];  // count[0] -> circular, count[1] -> square

        for (int s : students) count[s]++;

        for (int i = 0; i < sandwiches.length; i++) {
            if (count[sandwiches[i]] == 0) {
                return sandwiches.length - i;
            }
            count[sandwiches[i]]--;
        }

        return 0;
    }
}
