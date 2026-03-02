class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] ans = new int[v];
//Intuition
// A node is called safe if:
// Starting from that node,
// All possible paths eventually end at a terminal node (node with no outgoing edges).
// And it should NOT be part of a cycle.
//  Core Idea:
// Unsafe nodes are:
// Nodes that are part of a cycle
// OR nodes that can reach a cycle
//  Safe nodes are:
// Nodes that cannot reach any cycle
// Eventually they lead to a terminal node
// So the problem becomes:
//  How do we detect nodes that are part of a cycle or lead to a cycle?
        for(int i=0;i<v;i++) {
            if(vis[i] == 0) {
                dfs(i,graph,vis,pathVis,ans);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<v;i++) {
            if(ans[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }
    boolean dfs(int node,int[][] graph,int[] vis,int[] pathVis,int[] ans) {
        vis[node] = 1;
        pathVis[node] = 1;
        //Traversing the neighbor nodes
        for(int neighbor : graph[node]) {
            //when the neighbor node is not visied
            if(vis[neighbor] == 0) {
                if(dfs(neighbor,graph,vis,pathVis,ans) == true) {
                    return true;
                }
            }
            //if the node has been previously visited and also marked as 1
            //in pathVis array also then it means the node is currently in the path
            //is forming a cycle so then return true
            else if(pathVis[neighbor] == 1) {
                return true;
            }
        }

        //if the program comes upto this line means the program didn't encounter
        //return true which means the cycle hasn't formed in the current path so
        //mark the current node as a safe node and mark pathVis as 0 and return false
        //which means there no cycle formed
        ans[node] = 1;//1 means it is a safe node
                      //defaultly ans stores 0's for all nodes which means unsafe we inly
                      //marked 1 for only those safe nodes
        pathVis[node] = 0;
        return false;
    }

}