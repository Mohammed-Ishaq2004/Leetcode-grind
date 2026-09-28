class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = power(5, evenPositions);
        long oddWays = power(4, oddPositions);

        return (int) ((evenWays * oddWays) % MOD);
    }

    static long power(long x, long n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        // Solve half
        long half = power(x, n / 2);

        // Even exponent
        if (n % 2 == 0) {
            return (half * half) % MOD;
        }

        // Odd exponent
        return ((half * half) % MOD * x) % MOD;
    }
}