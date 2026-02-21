class Solution {
    public int numEnclaves(int[][] grid) {
        //This problem is same as the problem surrounded regions which
        //did using DFS that problem also solved by using bfs
        //BFS
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];//0-->unvisited , 1-->visited
        int[] dirRows = {-1,0,1,0};//up,right,down,left
        int[] dirCols = {0,1,0,-1};
        for(int i=0;i<n;i++) {
            //check first row
            if(grid[0][i] == 1) {
                q.add(new int[]{0,i});
                visited[0][i] = 1;
            }
            //check last row
            if(grid[m-1][i] == 1) {
                q.add(new int[]{m-1,i});
                visited[m-1][i] = 1;
            }
        }
        for(int j=0;j<m;j++) {
            //check first column
            if(grid[j][0] == 1) {
                q.add(new int[]{j,0});
                visited[j][0] = 1;
            }
            //check last column
            if(grid[j][n-1] == 1) {
                q.add(new int[]{j,n-1});
                visited[j][n-1] = 1;
            }
        }

        //BFS to mark as visited for all boundaries connected lands
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];
            for(int i=0;i<4;i++) {
                int newRow = curRow + dirRows[i];
                int newCol = curCol + dirCols[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    q.add(new int[]{newRow,newCol});
                } 
            }
        }

        //counting landcells which are not vsited means these are not in the boundaries
        int enclaves=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && visited[i][j] != 1) enclaves++;
            }
        }
        return enclaves;
    }
}