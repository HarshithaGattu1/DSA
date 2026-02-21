class Solution {
    public int[][] updateMatrix(int[][] mat) {
    //     Queue<int[]> q = new LinkedList<>();
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int[][] visited = new int[m][n];
    //     int[][] distances = new int[m][n];
    //     for(int i=0;i<m;i++) {
    //         for(int j=0;j<n;j++) {
    //             if(mat[i][j] == 0) {
    //                  q.add(new int[]{i,j,0});
    //                  visited[i][j] = 1;
    //             }
    //         }
    //     }
    //     int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    //     while(!q.isEmpty()) {
    //         int[] curr = q.poll();
    //         int curRow = curr[0];
    //         int curCol = curr[1];
    //         int step = curr[2];
    //         distances[curRow][curCol] = step;
    //         for(int[] d : dirs) {
    //             int r = curRow + d[0];
    //             int c = curCol + d[1];
    //             if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] != 1) {
    //                 visited[r][c] = 1;
    //                 q.add(new int[]{r,c,step+1});
    //             }
    //         }
    //     }
    //     return distances;
    // }


    //Instead we can use distances array itself as visited array also 
    //initially when finding 0's in the array if a 0 occurs store 0 in 
    //distances array if not store -1.This way space for visited array
    //is not needed and optimized
    //In this approach i am not storing steps in queue also
    Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                     q.add(new int[]{i,j});
                     distances[i][j] = 0;
                }
                else distances[i][j] = -1;
            }
        }
        int[] rows = {1,-1,0,0};
        int[] cols = {0,0,1,-1};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];
            for(int dir=0;dir<4;dir++) { 
                int nr = curRow + rows[dir];//nr --> newRow
                int nc = curCol + cols[dir];//nc --> newCol
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && distances[nr][nc] == -1) {
                    q.add(new int[]{nr,nc});
                    distances[nr][nc] = distances[curRow][curCol]+1;
                }
            }
        }
        return distances;

}
     }
