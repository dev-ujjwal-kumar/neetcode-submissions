class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[2];

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(mp.containsKey(complement)){
                res[0] = mp.get(complement);
                res[1] = i;
            }else{
                mp.put(nums[i], i);
            }
        }
        return res;       
    }
}
