class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length - 1;
            while(start < end){
                int threeSum = nums[i] + nums[start] + nums[end];
                if(threeSum > 0){
                    end--;
                }else if(threeSum < 0){
                    start++;
                }else{
                    List<Integer> triplet = Arrays.asList(nums[i], nums[start], nums[end]);
                    res.add(triplet);
                    start++;
                    //this is to avoid duplicates in the 2 sum. Eg. [0, 0, 0, 0]
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                }
            }            
        }

        return res;
        
    }
}
