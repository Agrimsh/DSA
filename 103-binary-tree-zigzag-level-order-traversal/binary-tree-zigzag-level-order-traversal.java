/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rtl = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(size, 0));
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int idx = rtl ? (size - 1 - i) : i;
                level.set(idx, curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            ans.add(level);
            rtl = !rtl; 
        }

        return ans;
    }
}