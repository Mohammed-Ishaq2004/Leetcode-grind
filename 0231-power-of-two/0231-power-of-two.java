class Solution {
    public boolean isPowerOfTwo(int n) {
        // Powers of two are strictly positive (0 & -1 == 0 and Integer.MIN_VALUE have only one set bit).
      return n > 0  &&  (n & (n-1) ) == 0;    
    }
}