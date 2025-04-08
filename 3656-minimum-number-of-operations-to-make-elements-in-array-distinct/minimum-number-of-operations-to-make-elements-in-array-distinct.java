import java.util.*;

public class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int start = 0;

        while (start < nums.length) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicates = false;

            for (int i = start; i < nums.length; i++) {
                if (!seen.add(nums[i])) {
                    hasDuplicates = true;
                    break;
                }
            }

            if (!hasDuplicates) {
                break;
            }

           
            start += 3;
            operations++;
        }

        return operations;
    }
}
