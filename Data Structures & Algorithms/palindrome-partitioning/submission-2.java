class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);
        return res;        
    }

    private void dfs(int i, String s, List<String> part, List<List<String>> res){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j=i; j<s.length(); j++){
            if(isPallindrome(s, i, j)){
                part.add(s.substring(i, j+1)); // inclusion
                dfs(j+1, s, part, res);
                part.remove(part.size() - 1); // exclusion
            }
        }
    }

    private boolean isPallindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
