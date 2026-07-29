class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
            int currentSum=nums[left]+nums[i]+nums[right];
            if(currentSum==target){
                return currentSum;
            }
            //check for differences of sum with target the lesser the sum the closer it is to the target
            if(Math.abs(target-currentSum)<Math.abs(target-closestSum)){
                closestSum=currentSum;
            }
            if(currentSum<target){
                left++;
            }
            else{right--;}
        }
        }
        return closestSum;
    }
}