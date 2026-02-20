import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {

        List<String> parts = new ArrayList<>();

        int count = 0;
        int start = 0;

        // split into smallest special substrings
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') count++;
            else count--;

            // found a special substring
            if (count == 0) {

                // recursively process inside part
                String inner =
                        makeLargestSpecial(
                                s.substring(start + 1, i)
                        );

                parts.add("1" + inner + "0");

                start = i + 1;
            }
        }

        // sort descending to get lexicographically largest
        Collections.sort(parts, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();

        for (String str : parts) ans.append(str);

        return ans.toString();
    }
}