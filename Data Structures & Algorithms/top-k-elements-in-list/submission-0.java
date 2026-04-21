class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[k];
        int j = 0;

        //creating a frequency map
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        //creating a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                    (a, b) -> a.getValue() - b.getValue());
        
        //adding elements to the mean heap
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        while(!minHeap.isEmpty()){
            result[j++] = minHeap.poll().getKey();
        }

        return result;        
    }
}
