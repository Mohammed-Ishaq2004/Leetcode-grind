class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(String num, int target, int index,
                            long value, long prev,
                            String expr, List<String> ans) {

        // We used all digits
        if (index == num.length()) {
            if (value == target) {
                ans.add(expr);
            }
            return;
        }

        // Try every possible number starting at index
        for (int i = index; i < num.length(); i++) {

            // Don't allow numbers like "05"
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            // First number: no operator before it
            if (index == 0) {
                backtrack(num, target, i + 1,
                          curr, curr, part, ans);
            } else {
                // +
                backtrack(num, target, i + 1,
                          value + curr, curr,
                          expr + "+" + part, ans);

                // -
                backtrack(num, target, i + 1,
                          value - curr, -curr,
                          expr + "-" + part, ans);

                // *
                backtrack(num, target, i + 1,
                          value - prev + prev * curr,
                          prev * curr,
                          expr + "*" + part, ans);
            }
        }
    }
}