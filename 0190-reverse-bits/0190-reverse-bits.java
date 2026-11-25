class Solution {
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
                result <<= 1;      // push result left to make space
                result |= (n & 1); // grab last bit of n and put it at the end of result 
                n >>>= 1;          // drop last bit of n (unsigned shift)
        }
        return result ;
    }
}