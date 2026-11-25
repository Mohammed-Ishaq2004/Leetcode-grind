class Solution {
    public int singleNumber(int[] nums) {
        int ones=0,twos=0;
        for(int num : nums ){
            // Add to ones if not already in twos
            ones = (ones ^ num) & ~twos;
            // Add to twos if not in the updated ones
            twos = (twos ^ num) & ~ones;
        }
        return ones ;
    }
}