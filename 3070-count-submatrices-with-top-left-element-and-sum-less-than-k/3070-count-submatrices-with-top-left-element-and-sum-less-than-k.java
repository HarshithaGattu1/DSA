class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i-1 < 0 && j-1 < 0) preSum[i][j] = grid[i][j];
                else if(i-1 < 0 && j-1 >= 0) preSum[i][j] = preSum[i][j-1]+grid[i][j];
                else if(j-1 < 0 && i-1 >= 0) preSum[i][j] = preSum[i-1][j] + grid[i][j];
                else
                    preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]+grid[i][j]-preSum[i-1][j-1];
            }
        }
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(preSum[i][j] <= k) count++;
                else break;
            }
        }
        return count;
    }
}