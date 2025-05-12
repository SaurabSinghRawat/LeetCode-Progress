import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] count = new int[10];
        
       
        for (int d : digits) {
            count[d]++;
        }

    
        for (int i = 100; i < 1000; i += 2) { 
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            int[] tempCount = Arrays.copyOf(count, 10);
            tempCount[a]--;
            tempCount[b]--;
            tempCount[c]--;

            if (tempCount[a] >= 0 && tempCount[b] >= 0 && tempCount[c] >= 0) {
                result.add(i);
            }
        }

        int[] output = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            output[idx++] = num;
        }

        return output;
    }
}
