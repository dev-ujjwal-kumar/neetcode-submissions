class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Creating frequency map
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Creating MaxHeap to stored the frequency
        for(int cnt : count){
            if(cnt > 0){
                maxHeap.offer(cnt);
            }                
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        // iterating till we have the elements present
        while(!q.isEmpty() || !maxHeap.isEmpty()){
            time++;
            // if maxHeap is Empty then we are settng the time to latest time in queue
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = maxHeap.poll() - 1; // reducing the count by 1
                if(cnt > 0){
                    q.offer(new int[]{cnt, time + n}); // inserting the element in (remaining_count_after_running, next_available_time)
                }
            }

            // we have element inqueue and it can b executed at current time then placing it in heap
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;        
    }
}
