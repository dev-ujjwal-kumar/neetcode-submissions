class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        placeQueen(0, board, res);
        return res;        
    }

    private void placeQueen(int r, char[][] board, List<List<String>> res){
        if(r == board.length){
            List<String> temp = new ArrayList<>();
            for(char[] row : board){
                temp.add(new String(row));
            }
            res.add(temp);
            return;
        }
        for(int c=0; c<board.length; c++){
            if(isSafe(r, c, board)){
                board[r][c] = 'Q'; // placing the Queen
                placeQueen(r+1, board, res); // recursion call
                board[r][c] = '.'; // Bacxktracking
            }
        }
    }

    private boolean isSafe(int r, int c, char[][] board){
        // checking upper rows
        for(int i=r-1; i>=0; i--){
            if(board[i][c] == 'Q') return false;
        }

        //checking upper left daignol
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        //checking upper right dig.
        for(int i=r-1, j=c+1; i>=0 && j< board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}
