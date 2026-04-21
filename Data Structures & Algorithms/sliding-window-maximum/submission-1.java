class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int size = nums.length;
        int res[] = new int[size - k + 1];
        int resIndex = 0;

        for(int i=0; i<size; i++){
            heap.offer(new int[]{nums[i], i});
            if(i >= k - 1){
                while(heap.peek()[1] <= i-k){
                    heap.poll();
                }
                res[resIndex++] = heap.peek()[0];
            }
        }
        return res;        
    }
}
