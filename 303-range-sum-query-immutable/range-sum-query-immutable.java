class NumArray {

    int[] seg;
    int[] arr;
    int n;

    public NumArray(int[] nums) {

        n = nums.length;
        arr = nums;
        seg = new int[4 * n];

        buildtree(0, 0, n - 1);
    }

    public void buildtree(int i, int l, int r) {

        if (l == r) {
            seg[i] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        buildtree(2 * i + 1, l, mid);
        buildtree(2 * i + 2, mid + 1, r);

        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public int rangesumquery(int i, int start, int end, int l, int r) {

        // No overlap
        if (r < start || l > end)
            return 0;

        // Complete overlap
        if (l >= start && r <= end)
            return seg[i];

        int mid = (l + r) / 2;

        int left = rangesumquery(2 * i + 1, start, end, l, mid);
        int right = rangesumquery(2 * i + 2, start, end, mid + 1, r);

        return left + right;
    }

    public int sumRange(int left, int right) {

        return rangesumquery(0, left, right, 0, n - 1);
    }
}