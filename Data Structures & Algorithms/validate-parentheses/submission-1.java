class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
                continue;
            }else if( c == ')' && (st.empty() || st.peek() != '(')){    
                return false;
            }else if( c == '}' && (st.empty() || st.peek() != '{')){
                return false;
            }else if( c == ']' && (st.empty() || st.peek() != '[')){
                return false;
            }
            st.pop();

        }

        if(!st.empty()){
            return false;
        }

        return true;
        
    }
}
