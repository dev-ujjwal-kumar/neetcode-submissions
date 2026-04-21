class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            while((s.charAt(start) == ' ' || !Character.isLetterOrDigit(s.charAt(start))) && (start < end)){
                start++;
            }
            while((s.charAt(end) == ' ' || !Character.isLetterOrDigit(s.charAt(end))) && (start < end)){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                // System.out.println(s.charAt(start) + " " + s.charAt(end));
                return false;
            }
            start++;
            end--;
        }

        return true;
        
    }
}
