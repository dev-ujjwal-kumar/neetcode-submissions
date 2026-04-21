class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            while(!st.empty() && temp[st.peek()] < temp[i]){
                int resIndex = st.pop();
                res[resIndex] = i - resIndex;
            }
            st.push(i);
        }

        return res;        
    }
}
