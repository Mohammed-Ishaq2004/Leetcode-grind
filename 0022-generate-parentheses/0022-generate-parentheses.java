public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); // Acts as the sb/current string path

        backtrack(0, 0, n, sb, result);
        return result;
    }

    private void backtrack(int openN, int closedN, int n, StringBuilder sb, List<String> result) {
        // Base case: when open and closed parentheses both equal n
        if (openN == n && closedN == n) {
            result.add(sb.toString());
            return;
        }

        // Only add an open parenthesis if open count is less than n
        if (openN < n) {
            sb.append("(");
            backtrack(openN + 1, closedN, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); // Cleanup/pop from sb
        }

        // Only add a closing parenthesis if closed count is less than open count
        if (closedN < openN) {
            sb.append(")");
            backtrack(openN, closedN + 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); // Cleanup/pop from sb
        }
    }
}