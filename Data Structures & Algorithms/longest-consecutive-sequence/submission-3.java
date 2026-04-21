class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(st.contains(nums[i]-1)){
                continue;
            }else{
                int count = 1;
                int increment = 1;
                while(st.contains(nums[i]+increment)){
                    count++;
                    increment++;
                }
                longest = Math.max(count, longest);
            }            
        }
        return longest;        
    }
}
