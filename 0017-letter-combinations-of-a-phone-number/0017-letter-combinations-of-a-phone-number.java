class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrack(0, phone, digits, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(int index, String[] phone, String digits, StringBuilder curr, List<String> ans) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            curr.append(ch);//choose
            backtrack(index + 1, phone, digits, curr, ans);//explore
            curr.deleteCharAt(curr.length() - 1); //undo
        }
    }
}