class Solution {

    private boolean isPossible(int[] bloomDay, int day, int m, int k) {

        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                flowers++;//incrementing until adjacency k limit is reached 

                if (flowers == k) {
                    bouquets++;//make a bouqet and flowers to zero so a next bouqet be made from adjacent flowers 
                    flowers = 0;
                }

            } else {//if no bloom then fresh flower adjacency counting strts
                flowers = 0;
            }
        }

        return bouquets >= m;//we return bouqets if its >=m 
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}