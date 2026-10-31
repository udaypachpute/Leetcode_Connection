class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {

            int right = 0;

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    // Mirror: swap the two directions
                    int temp = right;
                    right = dp[j];
                    dp[j] = temp;

                } else {

                    // Empty cell: combine both directions
                    int ways = (right + dp[j]) % MOD;

                    right = ways;
                    dp[j] = ways;
                }
            }
        }

        return dp[n - 1];
    }
}