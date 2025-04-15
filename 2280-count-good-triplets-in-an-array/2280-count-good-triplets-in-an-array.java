class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        // Map each value in nums2 to its index
        int[] indexInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            indexInNums2[nums2[i]] = i;
        }

        // Map nums1 to positions in nums2
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = indexInNums2[nums1[i]];
        }

        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);

        // Initialize rightTree with all frequencies
        for (int i = 0; i < n; i++) {
            rightTree.update(mapped[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            // Before processing i-th element, remove it from rightTree
            rightTree.update(mapped[i], -1);

            long leftLess = leftTree.query(mapped[i] - 1); // # of elements less on the left
            long rightGreater = rightTree.query(n - 1) - rightTree.query(mapped[i]); // # greater on right

            count += leftLess * rightGreater;

            // Add current to leftTree
            leftTree.update(mapped[i], 1);
        }

        return count;
    }

    // Fenwick Tree (Binary Indexed Tree)
    class FenwickTree {
        private long[] bit;
        private int n;

        FenwickTree(int size) {
            n = size;
            bit = new long[n + 1];
        }

        void update(int index, int delta) {
            index++; // 1-based indexing
            while (index <= n) {
                bit[index] += delta;
                index += index & -index;
            }
        }

        long query(int index) {
            index++; // 1-based indexing
            long sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
