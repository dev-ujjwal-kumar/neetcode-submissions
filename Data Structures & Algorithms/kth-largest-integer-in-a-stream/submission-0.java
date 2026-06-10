class KthLargest {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++){
            maxHeap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);

        // removing k-1 elemts from heap
        List<Integer> kList = new ArrayList<>();
        int res;
        int counter = 0;
        if(k > maxHeap.size()) return -1;
        while(counter < k-1){
            kList.add(maxHeap.poll());
            counter++;
        }

        res = maxHeap.peek();

        for(Integer num : kList){
            maxHeap.offer(num);
        }

        return res;
    }
}
