class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowId=searchPotentialRow(matrix, target);
        if(rowId != -1) return binarySearchOverRow(rowId,matrix,target);
        else return false;
    }
    private int searchPotentialRow(int[][] matrix,int target){
        int low=0;
        int high=matrix.length-1;//total no. of rows - 1
        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]){
                return mid;
            } 
            else if(target > matrix[mid][0]) low=mid+1;
            else if(target < matrix[mid][0]) high=mid-1;
        }
        return -1;
    }
    private boolean binarySearchOverRow(int rowId, int[][] matrix, int target){
        int low = 0;
        int high=matrix[rowId].length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[rowId][mid]==target) return true;
            else if(matrix[rowId][mid] > target) high = mid-1;
            else low=mid+1;
        }
        return false;
    }
}