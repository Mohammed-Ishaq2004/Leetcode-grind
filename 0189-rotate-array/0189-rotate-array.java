class Solution {
    public void rotate(int[] nums, int k) {

            int n=nums.length;
            k= k % n ;
            reverseArray(nums, 0, n - 1);//(nums, 0, k-1) for left follow this order of reversal
            reverseArray(nums, 0, k - 1);//(nums, k, n-1)
            reverseArray(nums, k, n - 1);//(nums, 0, n-1)
    
    }//helper function
     void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
