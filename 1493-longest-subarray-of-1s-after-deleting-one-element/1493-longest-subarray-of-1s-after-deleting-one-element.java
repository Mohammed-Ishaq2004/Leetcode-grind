class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. Count zeros in current window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // 2. Shrink window from left if we have more than 1 zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // 3. Window size is (right - left + 1). 
            // Since we MUST delete 1 element, usable length is (right - left).
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}