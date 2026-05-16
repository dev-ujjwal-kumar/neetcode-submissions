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
    private int maxPathDFS(TreeNode node, int[] maxValue){
        if(node == null)
            return 0;
        
        // if it's -ve sum then append 0        
        int leftMax = Math.max(0,maxPathDFS(node.left, maxValue));
        int rightMax = Math.max(0, maxPathDFS(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDFS(root, maxValue);
        return maxValue[0];        
    }
}
