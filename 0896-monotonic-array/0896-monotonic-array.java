class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false; // Can't be increasing if a previous element is larger
            }
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false; // Can't be decreasing if a previous element is smaller
            }
        }

        return isIncreasing || isDecreasing;//or operator if atleat one is true returns true 
    }
}