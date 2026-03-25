
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 12345;

        int size = m * n;
        int[] arr = new int[size];

        // Step 1: Flatten 2D → 1D
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j] % MOD;
            }
        }

        // Step 2: Build prefix product directly into result array
        int[] res = new int[size];
        res[0] = 1;

        for (int i = 1; i < size; i++) {
            res[i] = (res[i - 1] * arr[i - 1]) % MOD;
        }

        // Step 3: Traverse from right and multiply suffix
        int suffix = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] = (res[i] * suffix) % MOD;
            suffix = (suffix * arr[i]) % MOD;
        }

        // Step 4: Convert back to 2D
        int[][] result = new int[m][n];
        k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = res[k++];
            }
        }

        return result;
    }
}