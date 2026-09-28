
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
        // Add a copy of the current subset to the result list
        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Case of including the number
            tempSet.add(nums[i]);

            // Backtrack to find all subsets with the new element included
            backtrack(resultSets, tempSet, nums, i + 1);

            // Case of not-including the number (Backtrack/remove last added element)
            tempSet.remove(tempSet.size() - 1);
        }
    }
}