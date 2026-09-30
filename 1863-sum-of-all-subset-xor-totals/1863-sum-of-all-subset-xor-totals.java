class Solution {
    public int subsetXORSum(int[] nums) {
                return calculate(nums, 0, 0);
    }

    private int calculate(int[] nums, int index, int xorTotal) {

        // All elements have been considered
        if (index == nums.length) {
            return xorTotal;
        }

        // Choice 1: Include the current element
        int take = calculate(
            nums, index + 1, xorTotal ^ nums[index]
        );

        // Choice 2: Exclude the current element
        int skip = calculate(
            nums, index + 1, xorTotal
        );

        // Sum of both branches
        return take + skip;
    }
}

// Recursion explores every possible subset by taking or skipping each element.
// When all elements are considered, it returns that subset's XOR total.
// The take and skip branches return their sums, which are added together
// to get the total XOR sum of all subsets.