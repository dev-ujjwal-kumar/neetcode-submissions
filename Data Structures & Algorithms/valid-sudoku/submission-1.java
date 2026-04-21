class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                // if there is no element present then continue to next iteration
                if(board[r][c] == '.' ) continue;

                // Calculating the index for the 3 X 3 square
                String squareIndex = (r/3) + "," + (c/3);

                // we have to check for 3 condition to  ake our sodoku invalid
                // 1. No should be unique in that row.
                // 2. No should be unique in that col.
                // 3. No should be unique in that 3 X 3 square

                if((rows.computeIfAbsent(r, k -> new HashSet<>())
                    .contains(board[r][c])) ||
                    (cols.computeIfAbsent(c, k -> new HashSet<>())
                    .contains(board[r][c])) ||
                    (squares.computeIfAbsent(squareIndex, k -> new HashSet<>())
                    .contains(board[r][c]))){
                        return false;
                    }

                    // adding new elements to our map
                    rows.get(r).add(board[r][c]);
                    cols.get(c).add(board[r][c]);
                    squares.get(squareIndex).add(board[r][c]);

            }
        }

        return true;

        
    }
}
