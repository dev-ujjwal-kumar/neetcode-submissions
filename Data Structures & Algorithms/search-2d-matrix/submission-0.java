class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        // System.out.println(row + " "  +col);
        for(int i=0; i<row; i++){
            // System.out.println(matrix[i][0] + " " + matrix[i][3]);
            if(matrix[i][0] <= target && matrix[i][col-1] >= target){
                int start = 0;
                int end = col - 1;
                int mid;
                // System.out.println("In loop");
                while(start <= end){
                    mid = start + ((end-start)/2);
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] < target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }

        return false;
        
    }
}
