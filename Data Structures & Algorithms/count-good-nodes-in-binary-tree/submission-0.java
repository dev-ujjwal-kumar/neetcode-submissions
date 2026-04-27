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
    private int dfs(TreeNode root, int msf){
        if(root == null)
            return 0;
        
        int res = (root.val >= msf) ? 1 : 0;        
        msf = Math.max(msf, root.val); // max so far
        res += dfs(root.left, msf);
        res += dfs(root.right, msf);
        return res;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
