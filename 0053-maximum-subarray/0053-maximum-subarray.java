class Solution {
    public int maxSubArray(int[] nums) {
        long maxi = Long.MIN_VALUE;
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum>maxi){
                maxi=sum;
            }
            //a negative sum would only reduce the potential maximum sum of any future subarray.
            if(sum<0){
                sum=0;
            }
        }
        return (int) maxi;
    }
}//can also use max sum and curr sum thats easy but above code is also the ssame