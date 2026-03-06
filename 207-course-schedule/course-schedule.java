class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }   
        int[] indegree = new int[numCourses];
        //building adj and indegree
        for(int[] pr : prerequisites) {
            int course = pr[0];
            int preq = pr[1];
            adj.get(preq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int coursesTaken = 0;
        while(!q.isEmpty()) {
            int c = q.poll();
            coursesTaken++;
            for(int neighborCourse : adj.get(c)) {
                indegree[neighborCourse]--;
                if(indegree[neighborCourse] == 0) {
                    q.offer(neighborCourse);
                }
            }
        }
        return coursesTaken == numCourses;
    }
}