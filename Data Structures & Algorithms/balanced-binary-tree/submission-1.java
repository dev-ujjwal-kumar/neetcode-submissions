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
    private int heightOfTree(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        System.out.println(leftHeight-rightHeight);
        if(Math.abs(leftHeight - rightHeight) > 1) 
            return false;
        // checking each node node
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
