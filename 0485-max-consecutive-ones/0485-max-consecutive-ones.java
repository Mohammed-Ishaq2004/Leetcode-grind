class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //count to zero if encountered a non 1 element 
        int n=nums.length;
        int count=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
            }
            else count =0;
            max= Math.max(max,count);
        }
    return max;
    }
}