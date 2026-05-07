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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        // Build a hash map mapping each value in inorder to its index
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        // Building the tree
        TreeNode root = buildTree(preorder, 0, preorder.length - 1,
                                    inorder, 0, inorder.length - 1, inMap);

        return root;        
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){

        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        // 1. Root is the first element in current preorder range
        TreeNode root = new TreeNode(preorder[preStart]);

        // 2. Find root index in inorder to split Left and Right subtrees
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        // 3. Recursively build subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, 
                          inorder, inStart, inRoot - 1, inMap);
        
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, 
                           inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
