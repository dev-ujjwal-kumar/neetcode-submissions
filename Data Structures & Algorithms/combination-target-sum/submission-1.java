class Solution {
    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, int level){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || level >= nums.length){
            return;
        }

        curr.add(nums[level]);
        // Inclusion call without increasing level to allow multiple occurance of same no
        dfs(nums, target - nums[level], res, curr, level);
        curr.remove(curr.size() - 1); // Backtracking call
        dfs(nums, target, res, curr, level + 1); // exclusion call with increased level
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, target, res, curr, 0);
        return res;        
    }
}
