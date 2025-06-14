class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);

        char toReplaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = (toReplaceMax == ' ') ? s : s.replace(toReplaceMax, '9');
        int maxVal = Integer.parseInt(maxStr);

        // Get min value
        char toReplaceMin = ' ';
        for (char c : s.toCharArray()) {
            if (c != '0') {
                toReplaceMin = c;
                break;
            }
        }
        String minStr = (toReplaceMin == ' ') ? s : s.replace(toReplaceMin, '0');
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
}
