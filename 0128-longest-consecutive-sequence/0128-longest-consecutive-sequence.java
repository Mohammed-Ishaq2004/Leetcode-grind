class Solution {
    public int longestConsecutive(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Add all elements to a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            // ONLY start building a sequence if 'num' is the absolute START
            // (i.e., num - 1 does NOT exist in the set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count upwards as long as consecutive elements exist
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Track the maximum streak length found so far
                if (currentStreak > maxLength) {
                    maxLength = currentStreak;
                }
            }
        }

        return maxLength;
    }
}