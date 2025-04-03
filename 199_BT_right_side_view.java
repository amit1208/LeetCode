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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>(); 

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode t = q.poll();

            if (t != null) { 
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                
                if (q.peek() == null) list.add(t.val);
            } else if (!q.isEmpty()) { 
                q.add(null);
            }
        }
        return list;
    }
}
