class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int index=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];//expands window to the right 
            //down we r using while instead of if because while makes sure until sum>=target the window completely shrinks down to minlen possible by keep on removing left element 
            while(sum>=target){
                minLen=Math.min(minLen,i-index+1);
                sum-=nums[index];//we dnt want next sum to include the left elemnt we r deleting in nxt step
                index++;
            }
        }
        return minLen== Integer.MAX_VALUE?0:minLen;
    }
}