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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        if(root == null){
            return levelOrder;
        }

        // Declaring the Queue to store node for traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> cl = new ArrayList<>(); // currentLevel 
            int clnc = queue.size(); // currentLevelNodeCount
            while(clnc > 0){
                TreeNode temp = queue.poll();
                cl.add(temp.val);
                // putting their child node in Queue;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);   
                clnc--;             
            }
            levelOrder.add(cl);
        }

        return levelOrder;

        
    }
}
