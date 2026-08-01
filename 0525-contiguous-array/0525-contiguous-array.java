class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store (running_sum -> first_seen_index)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum of 0 at index -1
        map.put(0, -1);
        
        int count = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat '0' as -1 and '1' as +1
            if (nums[i] == 1) {
                count = count + 1;
            } else {
                 count = count - 1;
            }
            
            if (map.containsKey(count)) {
                // If sum was seen before, calculate length of the subarray
                maxLength = Math.max(maxLength, i - map.get(count));//map.get(count) returns the last seen occurenece of the count
            } else {
                // Store first occurrence only
                map.put(count, i);
            }
        }
        
        return maxLength;
    }
}