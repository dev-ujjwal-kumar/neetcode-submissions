class Solution {
    private static void backtracking(StringBuilder currString, int openCount, int closedCount, int n, List<String> res){
        // Valid condition if openCount == closedCount == n
        if(openCount == closedCount && openCount == n){
            res.add(currString.toString());
            return;
        }

        // only add a closing pranthesis if closed < opne
        if(closedCount < openCount){
            currString.append(')');
            backtracking(currString, openCount, closedCount+1, n, res);
            currString.deleteCharAt(currString.length() - 1);
        }

        // only add oppen pranthesisi if open < n
        if(openCount < n){
            currString.append('(');
            backtracking(currString, openCount + 1, closedCount, n, res);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closedCount = 0;
        List<String> res = new ArrayList<>();
        backtracking(new StringBuilder(), openCount, closedCount, n, res);
        return res;
    }
}
