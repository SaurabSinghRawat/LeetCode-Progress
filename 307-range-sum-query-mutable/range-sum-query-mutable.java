class NumArray {
    int[] seg;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * idx + 1, l, mid);
        build(nums, 2 * idx + 2, mid + 1, r);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }

    private void updateTree(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            updateTree(2 * idx + 1, l, mid, pos, val);
        else
            updateTree(2 * idx + 2, mid + 1, r, pos, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int idx, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0; // no overlap
        if (ql <= l && r <= qr) return seg[idx]; // complete overlap

        int mid = (l + r) / 2;
        return query(2 * idx + 1, l, mid, ql, qr)
             + query(2 * idx + 2, mid + 1, r, ql, qr);
    }
}
