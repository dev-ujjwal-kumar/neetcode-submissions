class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> st = new HashSet<>();

        while(right < s.length()){
            // if(!Character.isLetterOrDigit(s.charAt(right))){
            //     right++;
            //     System.out.println
            //     continue;
            // }
            //if not found
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                right++;
            }else{
                maxLength = Math.max(maxLength, st.size());
                st.remove(s.charAt(left));
                left++;
            }
        }
        maxLength = Math.max(maxLength, st.size());

        return maxLength;
        
    }
}
