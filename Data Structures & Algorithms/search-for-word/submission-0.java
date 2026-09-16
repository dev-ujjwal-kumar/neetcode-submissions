class Solution {
    private int ROWS, COLS;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS]; // Visisted Array Deafult false

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;        
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length())
            return true;
        
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) || visited[r][c]){// if visisted also 
            return false;
        }
        visited[r][c] = true; // marking node as visisted 

        boolean res = dfs(board, word, r+1, c, i+1) ||
                      dfs(board, word, r-1, c, i+1) ||
                      dfs(board, word, r, c+1, i+1) ||
                      dfs(board, word, r, c-1, i+1);
        
        visited[r][c] = false;// Backtracking step

        return res;            
    }
}
