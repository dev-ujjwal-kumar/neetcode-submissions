class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int res[] = new int[size - k + 1];
        int j = 0;
        TreeMap<Integer, Integer> windowCount = new TreeMap<>();

        //creating first window
        for(int i=0; i<k; i++){
            windowCount.put(nums[i], windowCount.getOrDefault(nums[i], 0)+1);
        }

        //extracting max of first window
        res[j++] = windowCount.lastKey();

        //creating subscequent windows
        for(int i=k; i<nums.length; i++){
            //removing from window
            windowCount.computeIfPresent(nums[i-k], (key, val) -> val > 1 ? val-1: null);

            //adding to window
            windowCount.put(nums[i], windowCount.getOrDefault(nums[i], 0) + 1);

            //extracting max in that window
            res[j++] = windowCount.lastKey();            
        }

        return res;
        
    }
}
