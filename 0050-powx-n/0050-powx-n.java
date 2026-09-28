class Solution {

    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        // Solve half of the problem
        double half = power(x, n / 2);

        // Even exponent
        if (n % 2 == 0) {
            return half * half;
        }

        // Odd exponent
        return half * half * x;
    }
}