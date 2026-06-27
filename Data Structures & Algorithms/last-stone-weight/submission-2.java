class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<stones.length; i++){
            maxHeap.offer(stones[i]);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(y > x){
                maxHeap.offer(y-x);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
        // return res;      
    }
}
