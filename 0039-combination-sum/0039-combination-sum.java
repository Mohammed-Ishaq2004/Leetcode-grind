class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int i,int target,int[] candidates,List<Integer> curr,List<List<Integer>> ans){
        if(target==0) { 
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i==candidates.length){
            return;
        }
        //take the number
        curr.add(candidates[i]);
        backtrack(i,target-candidates[i],candidates,curr,ans);
        curr.remove(curr.size()-1);
        // skip the number and move to the next index without changing the target
        backtrack(i+1,target,candidates,curr,ans);
    }
}