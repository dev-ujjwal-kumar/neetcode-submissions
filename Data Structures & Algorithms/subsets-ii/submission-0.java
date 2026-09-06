class Solution {
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> subset, int level){
        if(level >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[level]);
        dfs(nums, res, subset, level + 1); // Inclusion step
        subset.remove(subset.size() - 1);

        // Calculating the next different no for the exclusion call
        while((level + 1 < nums.length) && (nums[level] == nums[level + 1])){
            level++;
        }
        dfs(nums, res, subset, level+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, subset, 0);
        return res;        
    }
}
