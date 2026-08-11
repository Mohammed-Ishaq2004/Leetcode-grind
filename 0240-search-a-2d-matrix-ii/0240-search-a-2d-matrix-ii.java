class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalColoumns = matrix[0].length;
        
        int row = 0;
        int col = totalColoumns - 1;

        while(row < totalRows && col >= 0){
            if(matrix[row][col]==target) return true ;
            else if(matrix[row][col] < target) row++;//go down
            else col--;//go left
        }
        return false;
    }
}