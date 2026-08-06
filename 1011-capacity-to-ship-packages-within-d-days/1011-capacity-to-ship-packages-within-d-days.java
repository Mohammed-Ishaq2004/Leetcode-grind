class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for (int weight : weights) {
            low = Math.max(low, weight);     // Minimum capacity must fit the heaviest package
            high += weight;                   // Maximum capacity carries everything in 1 day
        }
        
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (daysTook(weights, mid) <= days) {
                ans = mid;
                high = mid - 1;               // Try finding a smaller capacity
            } else {
                low = mid + 1;                // Capacity too small, increase it
            }
        }
        return ans;
    }

    private int daysTook(int[] weights, int capacity) {
        int daysTook = 1;                    // Start on day 1
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysTook++;                  // Start a new day
                currentLoad = weight;        // Put current package on the new day's ship
            } else {
                currentLoad += weight;       // Add package to current day's ship
            }
        }
        
        return daysTook;
    }
}