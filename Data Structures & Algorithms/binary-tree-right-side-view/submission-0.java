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
        List<Integer> rsv = new ArrayList<>(); // right side view
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return rsv;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> cl = new ArrayList<>();// current level
            int clnc = queue.size(); // current level node count
            int lr = clnc; // level right
            for(int i=0; i<clnc; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                if(i == clnc-1){
                    rsv.add(temp.val);
                }
            }
        }
        return rsv;
    }
}
