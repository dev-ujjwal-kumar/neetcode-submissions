class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int left = 0;
        int right = n-1;
        int maxL = height[0];
        int maxR = height[n-1];
        int res = 0;
        while(left < right){
            if(maxL < maxR){
                left++;
                maxL = Math.max(height[left], maxL);
                res += maxL - height[left];
            }else{
                right--;
                maxR = Math.max(height[right], maxR);
                res += maxR - height[right];
            }
        }

        return res;
        
    }
}
