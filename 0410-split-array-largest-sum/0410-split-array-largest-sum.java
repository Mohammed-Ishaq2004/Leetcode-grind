class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // Maximum single element,the range for answers starts from this 
            high += num;             // Sum of all elements
        }

        int result = high;//probable answer

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                result = mid;//this is a valid maximum sum which can be assigned to the subarray but we can also
                high = mid - 1; // Try to find a smaller valid maximum sum
            } else {
                low = mid + 1;  // Increase the allowed sum threshold
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}