class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // creating a map to store the position and speed
        Map<Integer, Integer> mp = new TreeMap<>(Comparator.reverseOrder());
        int n = position.length;
        for(int i=0; i<n; i++){
            mp.put(position[i], speed[i]);
        }

        Stack<Double> st = new Stack<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int p = entry.getKey(); // position
            int s = entry.getValue(); // speed

            Double timeTaken =(double) (target - p) / s;
            
            if(st.empty() || st.peek() < timeTaken){
                st.push(timeTaken);
            }
        }

        return st.size();        
    }
}
