import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            
            // Keep walking as long as the next number is exactly +1
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            
            // If the start and end are different, make a train "start->end"
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else { // Otherwise, it's just a single block "start"
                result.add(String.valueOf(start));
            }
        }
        
        return result;
    }
}