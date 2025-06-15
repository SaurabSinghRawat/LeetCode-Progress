class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        
        char[] maxChars = s.toCharArray();
        char toReplaceMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != ' ') {
            for (int i = 0; i < maxChars.length; i++) {
                if (maxChars[i] == toReplaceMax) maxChars[i] = '9';
            }
        }
        int a = Integer.parseInt(new String(maxChars));

        // Minimize
        char[] minChars = s.toCharArray();
        char toReplaceMin = ' ';
        if (minChars[0] != '1') {
            toReplaceMin = minChars[0];
            for (int i = 0; i < minChars.length; i++) {
                if (minChars[i] == toReplaceMin) minChars[i] = '1';
            }
        } else {
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] != '0' && minChars[i] != '1') {
                    toReplaceMin = minChars[i];
                    for (int j = 1; j < minChars.length; j++) {
                        if (minChars[j] == toReplaceMin) minChars[j] = '0';
                    }
                    break;
                }
            }
        }
        int b = Integer.parseInt(new String(minChars));

        return a - b;
    }
}
