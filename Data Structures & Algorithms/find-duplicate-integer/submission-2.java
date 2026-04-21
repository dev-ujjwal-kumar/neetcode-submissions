class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        for(int num : nums){
            int ind = Math.abs(num) - 1;
            if(nums[ind] < 0){
                return Math.abs(num);
            }
            nums[ind] *= -1;
        }

        return -1;
    }
}
