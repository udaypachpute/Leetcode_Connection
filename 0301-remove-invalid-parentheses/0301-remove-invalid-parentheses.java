class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum removals
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            }
            else if (ch == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                }
                else {
                    rightRemove++;
                }
            }
        }

        solve(s, 0, leftRemove, rightRemove, 0, "", set);

        return new ArrayList<>(set);
    }

    static void solve(String s, int index,
                      int leftRemove,
                      int rightRemove,
                      int balance,
                      String current,
                      Set<String> set) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                set.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        // '('
        if (ch == '(') {

            // Remove
            if (leftRemove > 0) {
                solve(
                    s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    current,
                    set
                );
            }

            // Keep
            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current + ch,
                set
            );
        }

        // ')'
        else if (ch == ')') {

            // Remove
            if (rightRemove > 0) {
                solve(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    current,
                    set
                );
            }

            // Keep
            if (balance > 0) {
                solve(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current + ch,
                    set
                );
            }
        }

        // Letter
        else {
            solve(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current + ch,
                set
            );
        }
    }
}