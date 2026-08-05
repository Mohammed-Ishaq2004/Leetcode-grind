class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(n==1)return nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==0&&nums[mid]!=nums[mid+1])return nums[mid];
            if(mid==n-1&&nums[n-1]!=nums[n-2])return nums[mid];
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])return nums[mid];
            if(mid%2==0){//check whether the halves are divided into even or odd numbers do the dry run of big examples to understand apnacollege good explanation
                if(nums[mid]==nums[mid-1]) high=mid-2;
                else low=mid+2;
            }
            else{
                if(nums[mid]==nums[mid-1]) low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }
}