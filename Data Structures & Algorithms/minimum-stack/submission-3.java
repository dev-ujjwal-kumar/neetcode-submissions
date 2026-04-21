class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        // There is update in min value
        if((!minStack.empty() && minStack.peek() >= val) || minStack.empty()){
            minStack.push(val);
        }
        stack.push(val);
        
    }
    
    public void pop() {
        // If poping value from main stack is top of minStack
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();        
    }
}
