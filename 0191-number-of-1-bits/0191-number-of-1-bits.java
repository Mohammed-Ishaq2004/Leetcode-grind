class Solution {
    public int hammingWeight(int n) {
        int count  = 0;
        for(int i=0;i<31;i++){
            // n & (1 << i) returns 2^i (not 1) when the i-th bit is set, so we check != 0
            if((n&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}