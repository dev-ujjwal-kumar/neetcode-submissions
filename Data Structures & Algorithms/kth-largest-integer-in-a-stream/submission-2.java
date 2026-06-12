class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++){
            if(minHeap.size() < k){
                minHeap.offer(nums[i]);
            }else{
                minHeap.offer(nums[i]);
                minHeap.poll();                
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
                minHeap.offer(val);
        }else{
            minHeap.offer(val);
            minHeap.poll();
            
        }

        return minHeap.peek();
    }
}
