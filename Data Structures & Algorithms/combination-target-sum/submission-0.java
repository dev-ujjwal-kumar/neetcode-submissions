class Solution {
    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> comb, int level){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(target < 0 || level >= nums.length){
            return;
        }

        comb.add(nums[level]);
        // Inclusion call without increasing level to allow multiple occurance of same no
        dfs(nums, target - nums[level], res, comb, level);
        comb.remove(comb.size() - 1); // Backtracking call
        dfs(nums, target, res, comb, level + 1); // exclusion call with increased level
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(nums, target, res, comb, 0);
        return res;        
    }
}
