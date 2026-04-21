class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String str : tokens){
            if(str.matches("-?\\d+")){
                st.push(Integer.parseInt(str));
            }else{
                int res = 0;
                int num2 = st.pop();
                int num1 = st.pop();
                switch(str){
                    case "+": res = num1 + num2;
                                break;
                    case "-": res = num1 - num2;
                                break;
                    case "*": res = num1 * num2;
                                break;
                    case "/": res = num1 / num2;
                                break;
                }
                System.out.println(res);
                st.push(res);
            }
        }

        return st.peek();        
    }
}
