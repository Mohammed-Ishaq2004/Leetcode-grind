class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;//break the loop cuz we only want the first elemmt which is lesser than next as pivot if not break then we get wrong pivot
            }
        }   
        if (index== -1){
        reverse(nums,0,nums.length-1);
        return;//execution ends here since no need to continue and swap  
        }
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                swap(nums,index,i);
                break;//break cuz we want to swap only the next largest in the suffix after the index
            }
        } 
        reverse(nums,index+1,nums.length-1);
    }
    private void reverse(int[] arr, int start,int end){//use private cuz only internal helper used to solve 
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    private void swap(int[] arr, int i,int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}