class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;//count of deviations where nums[i] > nums[i+1]
        for(int i =0;i<n;i++){
            if (nums[i]>nums[(i+1) % n]){//to avoid ArrayIndexOutOfBoundxsException since array is rotated
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}