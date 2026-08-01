import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Stores (remainder -> first_seen_index)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: remainder 0 exists at index -1
        map.put(0, -1);
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            // Calculate remainder modulo k
            int remainder = runningSum % k;
            
            // Handle negative remainders if any (though constraints say nums[i] >= 0)
            if (remainder < 0) {
                remainder += k;
            }
            
            if (map.containsKey(remainder)) {
                // Check if subarray length is at least 2
                int previousIndex = map.get(remainder);
                if (i - previousIndex >= 2) {
                    return true;
                }
            } else {
                // Store first occurrence only to keep the earliest index
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}