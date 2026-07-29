class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] numsWithIndices=new int[n][2];
        for(int i=0;i<n;i++){
            numsWithIndices[i][0]=nums[i];
            numsWithIndices[i][1]=i;
        }
        Arrays.sort(numsWithIndices, (a,b)->Integer.compare(a[0],b[0]));
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numsWithIndices[left][0] + numsWithIndices[right][0];
            if (sum == target) {
                return new int[]{numsWithIndices[left][1], numsWithIndices[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1}; // required return
    }
}

/*1. Create your "memory bank" [Key: Number, Value: Its Index]
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    // 2. Calculate what partner you need
    int complement = target - nums[i];
    
    // 3. Did we see that partner earlier?
    if (map.containsKey(complement)) {
        // Yes! Grab the partner's index, and pair it with my current index 'i'
        return new int[] { map.get(complement), i };
    }
    
    // 4. If not found, "remember" the current number and its index for later
    map.put(nums[i], i);
}*/