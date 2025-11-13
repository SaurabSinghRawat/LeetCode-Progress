class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak cannot be first or last
        if (i == 0 || i == n - 1) return false;

        // climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
