class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void perm(int[] nums, int level, List<List<Integer>> res){
        int n = nums.length;
        if(level == n){
            List<Integer> per = Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.toList());
            res.add(per);
        }
        
        for(int i=level; i<n; i++){
            swap(nums, level, i);
            perm(nums, level + 1, res); // genertating the combination with new element included
            swap(nums, level, i); // Backtracking step
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, res);
        return res;        
    }
}
