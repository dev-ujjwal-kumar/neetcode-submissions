class Solution {
    public int longestConsecutive(int[] nums) {
        int currCount = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int longest = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] - 1 == lastSmaller){
                currCount++;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){
                currCount = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(currCount, longest);
        }
        return longest;        
    }
}
