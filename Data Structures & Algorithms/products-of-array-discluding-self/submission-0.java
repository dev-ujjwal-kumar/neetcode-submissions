class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        int[] res = new int[n];
        suffix[n-1] = 1;
        prefix[0] = 1;
        int pdt = 1;
        for(int i=1; i<nums.length; i++){
            pdt *= nums[i-1];
            prefix[i] = pdt;
        }
        pdt = 1;
        for(int i=n-2; i>=0; i--){
            pdt *= nums[i+1];
            suffix[i] = pdt;
        }
        for(int i=0; i<n; i++){
            res[i] = suffix[i] * prefix[i];
        }
        return res;
        
    }
}  
