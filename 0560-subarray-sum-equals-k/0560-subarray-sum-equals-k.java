class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();//use hashmap concept of prefix sum and frequency it stores the prefix sum and its frequency

        map.put(0, 1);//initialize the map it means like 0 has occured one time at -1 index

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            if (map.containsKey(sum - k)) {//main logic we need prefix sum which is equal to currsum - k which gives us the knowledge if a subarray exists with sum k (k=currsum-prevsum)

                count += map.get(sum - k);//count increments the frequency occured of prev sum cuz many subarrays have diffstart and ends 
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);//we first add curr sum then check prefix sum then add the curr sum into the map 
        }

        return count;
    }
}