class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dirRows = {-1,0,1,0};//up,right,down,left
        int[] dirCols = {0,1,0,-1};
        int[][] visited = new int[m][n];
        for(int i=0;i<n;i++) {
            //check first row
            if(board[0][i] == 'O' && visited[0][i] == 0) {
                dfs(0,i,board,visited,dirRows,dirCols);
            }
            //check last row
            if(board[m-1][i] == 'O' && visited[m-1][i] == 0) {
                dfs(m-1,i,board,visited,dirRows,dirCols);

            }
        }

        for(int j=0;j<m;j++) {
            //check first column
            if(board[j][0] == 'O' && visited[j][0] == 0) {
                dfs(j,0,board,visited,dirRows,dirCols);

            }
            //check last column
            if(board[j][n-1] == 'O' && visited[j][n-1] == 0) {
                dfs(j,n-1,board,visited,dirRows,dirCols);
            }
        }
        //replace remaining O'S to X'S
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O' && visited[i][j] == 0) board[i][j] = 'X';
            }
        }    
    }
    void dfs(int r,int c,char[][] board,int[][] visited,int[] dirRows,int[] dirCols) {
        int m = board.length;
        int n = board[0].length;
        visited[r][c] = 1;
        for(int i=0;i<4;i++) {
            int nr = r+dirRows[i];
            int nc = c+dirCols[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O' && visited[nr][nc]!=1) {
                dfs(nr,nc,board,visited,dirRows,dirCols);
            } 
        }
    }
}