class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 1. Sort the array so duplicates are adjacent
        Arrays.sort(nums); 
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tempSet, int[] nums, int start) {
        // Add current subset to result
        ans.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // 2. Skip duplicates: if the current element is the same as 
            // the previous element at the same depth/level, skip it.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            tempSet.add(nums[i]);
            backtrack(ans, tempSet, nums, i + 1); // move to next index
            tempSet.remove(tempSet.size() - 1);  // backtrack
        }
    }
}