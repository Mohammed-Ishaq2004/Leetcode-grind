class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int  mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;;
            }
            else{
                high=mid-1;
            }
        }
        return low;// If target is not found, low points to the exact position where target should be inserted to maintain sorted order.
    }
}