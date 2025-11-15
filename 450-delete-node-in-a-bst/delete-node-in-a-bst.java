class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with two children
            TreeNode curr = root.right;
            while (curr.left != null) curr = curr.left;
            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }
        return root;
    }
}
