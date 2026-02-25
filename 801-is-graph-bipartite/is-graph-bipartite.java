class Solution {
    public boolean isBipartite(int[][] graph) {
        //dfs
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++) {
            if(color[i] == -1) {
                if(dfs(i,0,graph,color) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int node,int col,int[][] graph,int[] color) {
        color[node] = col;
        for(int neighbor : graph[node]) {
            if(color[neighbor] == -1) {
                if(dfs(neighbor,1-col,graph,color) == false) {
                    return false;
                }
            }
            else if(color[neighbor] == col) {
                return false;
            }
        }
        return true; 
     }
}