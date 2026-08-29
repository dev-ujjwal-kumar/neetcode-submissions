class Solution {
    private void subsetDfs(int[] nums, List<Integer> subset, List<List<Integer>> res, int level){
        if(level >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        // inclusion call
        subset.add(nums[level]);
        subsetDfs(nums, subset, res, level+1);
        subset.remove(subset.size() - 1); // Backtracking
        subsetDfs(nums, subset, res, level+1); // Exclusion call

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetDfs(nums, subset, res, 0);
        return res;
    }
}
