class Solution {
    public int[] countBits(int n) {

        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            //observe pattern in binary representaion of some numbers and devise a formula or pattern 
            // Set bits in i = set bits in i/2 (remove last bit) + last bit (0 or 1)
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}