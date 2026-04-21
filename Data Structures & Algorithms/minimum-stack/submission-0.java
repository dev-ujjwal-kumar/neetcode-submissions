class MinStack {
    int arr[] = new int[1000];
    int top;
    int minStack[] = new int[1000];

    public MinStack() {
        top = -1;        
    }
    
    public void push(int val) {
        if(top == -1 || minStack[top] > val){
            minStack[top+1] = val;
        }else{
            minStack[top+1] = minStack[top]; 
        }
    
        arr[++top] = val;
        
    }
    
    public void pop() {
        if(top != -1){
            top--;
        }        
    }
    
    public int top() {
        int res = top == -1 ? -1 : arr[top];
        return arr[top];        
    }
    
    public int getMin() {
        return minStack[top];
    }
}
