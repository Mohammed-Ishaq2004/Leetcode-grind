class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. If we see a 0, we use up one available zero flip
            if (nums[right] == 0) {
                k--;
            }

            // 2. If we exceeded allowed 0s, shrink the window from left
            while (k < 0) {
                if (nums[left] == 0) {
                    k++; // Reclaim a flip as the left 0 exits the window
                }
                left++;
            }
//we just maintaining a window with 2 zeroes at all times soi counting is not required just window size of right-left+1 is compared to get maxlen 
            // 3. Current window [left ... right] is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}