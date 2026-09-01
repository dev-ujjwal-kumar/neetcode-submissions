class Solution {
    private void dfs(int[] nums, int target, List<Integer> curr, List<List<Integer>> res, int level){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || level >= nums.length){
            return;
        }

        // inclusion call
        curr.add(nums[level]);
        dfs(nums, target - nums[level], curr, res, level + 1);
        curr.remove(curr.size() - 1); // Backtracking call

        // 2. Exclusion call: skip nums[level] AND identical Adjacent number
        int nextLevel = level + 1;
        while(nextLevel < nums.length && nums[level] == nums[nextLevel]){
            nextLevel++;
        }
        dfs(nums, target, curr, res, nextLevel); // Exclusion call
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, curr, res, 0);
        return res;       
    }
}
