class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        int totalStorage = 0;

        if(n==1 || n ==2) return 0;

        // calculate minimum left
        for(int i=1; i<n; i++){
            minLeft[i] = Math.max(minLeft[i-1], height[i-1]);
            // System.out.println(minLeft[i]);
        }

        // System.out.println("min right");
        // calculate minimum right
        for(int i=n-2; i!=0; i--){
            minRight[i] = Math.max(minRight[i+1], height[i+1]);
            // System.out.println(minRight[i]);
        }

        for(int i=0; i<n; i++){
            int currStorage = Math.min(minLeft[i], minRight[i]) - height[i];

            if(currStorage > 0){
                totalStorage += currStorage;
            }
        }

        return totalStorage;
        
    }
}
