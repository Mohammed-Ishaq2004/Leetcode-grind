class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;

        for (int num : nums) {
            if (num == 0) return 0;  // 0 found,exit and return 0
            if (num < 0) sign = -sign; // evry -ve changes the sign and at last the leftover -ve means the product sign is -ve
        }

        return sign;
    }
}