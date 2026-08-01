class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Frequency array to store count of remainders 0 to k-1
        int[] remainderCount = new int[k];
        
        // Base case: remainder 0 is seen once before starting (empty prefix)
        remainderCount[0] = 1;
        
        int runningSum = 0;
        int totalSubarrays = 0;
        
        for (int num : nums) {
            runningSum += num;
            
            // Calculate positive remainder (handles negative running sums)
            int remainder = (runningSum % k + k) % k;
            
            // Add the number of times this exact remainder was seen before
            totalSubarrays += remainderCount[remainder];
            
            // Increment the count for this remainder
            remainderCount[remainder]++;
        }
        
        return totalSubarrays;
    }
}