class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[256];
        Arrays.fill(count, 0);
        int lenS = s.length();
        int lenT = t.length();

        //if length are not same they can't be anagram
        if(lenS != lenT)
            return false;

        for(int i=0; i<lenS; i++){
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        } 

        for(int i=0; i<256; i++){
            if(count[i] != 0)
                return false;
        }

        return true;
    }
}
