class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        int indegree[] = new int[numCourses];

        for(int i = 0;i < numCourses; i++){
            graph[i] = new ArrayList();
        }

        for(int i =0;i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] = indegree[prerequisites[i][1]] + 1;
        }

        int count = 0;

        LinkedList<Integer> que = new LinkedList<>();
        for(int i = 0;i < numCourses; i++){
            if(indegree[i] == 0){
                que.addLast(i);
            }
        }
        while(que.size() != 0){
            int idx = que.removeFirst();
            count++;

            for(int ele: graph[idx]){
                if(--indegree[ele] == 0){
                    que.addLast(ele);
                }
            }

        }

        return count == numCourses ? true : false;

    }
}
