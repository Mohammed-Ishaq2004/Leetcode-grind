import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        
        // Find min and max
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Mark presence using a boolean array for constant-time lookups without hashing overhead
        boolean[] present = new boolean[max + 1];
        for (int num : nums) {
            present[num] = true;
        }
        
        // Collect missing values in sorted order
        List<Integer> missing = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!present[i]) {
                missing.add(i);
            }
        }
        
        return missing;
    }
}