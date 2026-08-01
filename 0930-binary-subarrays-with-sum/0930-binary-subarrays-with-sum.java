class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    // Helper function to count subarrays with sum <= maxGoal
    private int atMost(int[] nums, int maxGoal) {
        if (maxGoal < 0) return 0;
        
        int left = 0;
        int currentSum = 0;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink window if sum exceeds maxGoal
            while (currentSum > maxGoal) {
                currentSum -= nums[left];
                left++;
            }
            
            // All subarrays ending at 'right' starting from 'left' up to 'right' are valid
            count += (right - left + 1);
        }
        
        return count;
    }
}