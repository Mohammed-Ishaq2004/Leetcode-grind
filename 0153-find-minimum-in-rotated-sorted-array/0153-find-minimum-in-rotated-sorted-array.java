class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low < high){
            int mid=(low+high)/2;
            //remove the part where min is impossible to find
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{//bcoz nums[mid]<=high ,high can now occupy this position cuz there is no element smaller next to it  and the loop continuues until low== high which gives us our answer 
                high=mid;
            }
        }
        return nums[low];
    }
}