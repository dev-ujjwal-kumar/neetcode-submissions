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
    // Inorder traversal gives the nodes in sorted order
    private void inOrder(TreeNode node, List<Integer> sortedList){
        if(node == null)
            return;
        
        inOrder(node.left, sortedList);
        sortedList.add(node.val);
        inOrder(node.right, sortedList);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return (list.size() < k) ?  0 : list.get(k-1); 
        
    }
}
