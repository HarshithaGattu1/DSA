class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        int[][] distances = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                     q.add(new int[]{i,j,0});
                     visited[i][j] = 1;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];
            int step = curr[2];
            distances[curRow][curCol] = step;
            for(int[] d : dirs) {
                int r = curRow + d[0];
                int c = curCol + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] != 1) {
                    visited[r][c] = 1;
                    q.add(new int[]{r,c,step+1});
                }
            }
        }
        return distances;
    }
}
