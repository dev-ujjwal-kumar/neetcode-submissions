class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitCharMap = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String currStr, String digits){
        if(currStr.length() == digits.length()){
            res.add(currStr);
            return;
        }
        String chars = digitCharMap[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            backtrack(i+1, currStr + c, digits);
        }
    }
}
