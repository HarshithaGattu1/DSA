class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands=0;
        int[] dirRows = {1,0,-1,0};
        int[] dirCols = {0,1,0,-1};
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    islands++;
                    dfs(i,j,grid,visited,dirRows,dirCols);
                }
            }
        }
        return islands;
    }
    void dfs(int curRow,int curCol,char[][] grid,int[][] visited,int[] dirRows,int[] dirCols) {
        visited[curRow][curCol] = 1;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<4;i++) {
            int newRow = curRow+dirRows[i];
            int newCol = curCol+dirCols[i];
            if(newRow>=0&&newRow<m&&newCol>=0&&newCol<n&&grid[newRow][newCol]=='1'&&visited[newRow][newCol] != 1) {
                dfs(newRow,newCol,grid,visited,dirRows,dirCols);
            }
        }
    }
}