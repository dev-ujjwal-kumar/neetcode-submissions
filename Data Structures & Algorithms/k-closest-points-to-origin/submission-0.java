class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
                                    a[0] * a[0] + a[1] * a[1])
        );
        int[][] res = new int[k][2];
        

        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k){
                maxHeap.poll();                
            }
        }

        int i=0;
        while(!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll();
        }

        return res;
    }
}
