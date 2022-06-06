package com.koko.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[n][m]);
    }

    private int uniquePathsHelper(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        else if (m == 0 || n == 0) return 1;
        else if (dp[n][m] > 0) return dp[n][m];
        else return dp[n][m] = uniquePathsHelper(m - 1, n, dp) + uniquePathsHelper(m, n - 1, dp);
    }
}
