class Solution {

    void solve(int start, int k, int target,
               List<Integer> output,
               List<List<Integer>> ans) {

        // Combination complete
        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {

            output.add(i);

            solve(i + 1, k - 1, target - i,
                  output, ans);

            // Backtrack
            output.remove(output.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(1, k, n, output, ans);

        return ans;
    }
}