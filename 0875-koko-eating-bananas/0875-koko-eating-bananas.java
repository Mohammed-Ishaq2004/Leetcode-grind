class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=0;
        //we calculate max pile which gives us the upper bound of speeds at which koko can eat
        for(int pile: piles){ 
            high=Math.max(pile,high);
        }
        int ans = high;
        while(low<=high){
            int mid=low+(high-low)/2;
            long hours=0;
            for(int pile : piles){
            hours += (pile+mid-1)/mid;//ceil se faster hai(math.ceil(pile/mid)) the one i wrote is mathematical efficient in time also based on java division rules 
            } 
            if(hours<=h){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}