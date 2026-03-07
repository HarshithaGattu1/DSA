class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pr : prerequisites) {
            int prereq = pr[1];
            int course = pr[0];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] coursesInOrder = new int[numCourses];
        int index=0;
        while(!q.isEmpty()) {
            int c = q.poll();
            coursesInOrder[index++] = c;
            for(int course : adj.get(c)) {
                indegree[course]--;
                if(indegree[course] == 0) q.offer(course);
            }
        }
        
        return (index == numCourses) ? coursesInOrder : new int[]{};
    }
}