class Solution {
    private int findPivotIndex(int[] nums){
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        int mid = 0;
        int ans = Integer.MAX_VALUE;

        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[start] <= nums[mid]){
                ans = Math.min(nums[start], ans);
                start = mid + 1;
            }else{
                ans = Math.min(nums[mid], ans);
                end = mid - 1;
            }
        }

        return ans;            
    }

    public int findMin(int[] nums) {
        return findPivotIndex(nums);
        // System.out.println(pivotIndex);
        // return Math.min(nums[0], nums[(pivotIndex + 1) % nums.length]);
    }
}
