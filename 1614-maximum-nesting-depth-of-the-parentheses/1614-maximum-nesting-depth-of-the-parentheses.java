class Solution {
    public int maxDepth(String s) {

     //i need depth at each point increment at ( and decrement at ) maintain a max depth 

    int depth=0;
    int maxDepth=0;
    for(char ch : s.toCharArray()){
        if(ch == '(' ) depth++;
        else if(ch == ')' ) depth--;
        maxDepth = Math.max(depth , maxDepth);
    }
    return maxDepth;
    }
}