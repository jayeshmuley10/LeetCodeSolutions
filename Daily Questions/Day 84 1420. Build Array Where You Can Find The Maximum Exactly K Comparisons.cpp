class Solution {
 public:
  int numOfArrays(int n, int m, int k) {
    constexpr int kMod = 1'000'000'007;
    // dp[i][j][k] := # of ways to build an array of length i, where j is the
    // Max num and k is the `search_cost`
    vector<vector<vector<int>>> dp(
        n + 1, vector<vector<int>>(m + 1, vector<int>(k + 1)));
    // prefix[i][j][k] := sum(dp[i][x][k]), where 1 <= x <= j
    vector<vector<vector<int>>> prefix(
        n + 1, vector<vector<int>>(m + 1, vector<int>(k + 1)));

    for (int j = 1; j <= m; ++j) {
      dp[1][j][1] = 1;
      prefix[1][j][1] = j;
    }

    for (int i = 2; i <= n; ++i)                 // For each length
      for (int j = 1; j <= m; ++j)               // For each max value
        for (int cost = 1; cost <= k; ++cost) {  // For each cost
          // 1. appending any of [1, j] in i-th position
          //    doesn't change the max and cost
          // 2. appending j in i-th position
          //    make j the new max and cost 1
          dp[i][j][cost] = (static_cast<long>(j) * dp[i - 1][j][cost] +
                            prefix[i - 1][j - 1][cost - 1]) %
                           kMod;
          prefix[i][j][cost] = (dp[i][j][cost] + prefix[i][j - 1][cost]) % kMod;
        }

    int ans = 0;
    for (int j = 1; j <= m; ++j) {
      ans += dp[n][j][k];
      ans %= kMod;
    }
    return ans;
  }
};
