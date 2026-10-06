class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int i,int target,int[] candidates,List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i==candidates.length){
            return;
        }

        //include

        curr.add(candidates[i]);

        backtrack(i+1,target-candidates[i],candidates,curr,ans);//  Pass (i + 1) to move to the next candidate since each element can only be used once

        curr.remove(curr.size()-1);

        //  Skip duplicates for the "exclude" path to prevent generating identical combination sets
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        //exclude
        
        backtrack(i+1,target,candidates,curr,ans);
    }
}