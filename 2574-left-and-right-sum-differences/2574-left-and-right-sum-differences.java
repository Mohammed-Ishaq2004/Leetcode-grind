class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // Subtract current element from right sum to get the sum of elements strictly to the right
            rightSum -= nums[i];

            ans[i] = Math.abs(leftSum - rightSum);

            // Add current element to left sum for the next iteration
            leftSum += nums[i];
        }

        return ans;
    }
}