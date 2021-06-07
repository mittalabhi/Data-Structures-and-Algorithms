class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        ArrayList<Integer> ans = new ArrayList<>();

        LinkedList<Integer> que = new LinkedList<>();
        for(int i = 0;i < numCourses; i++){
            if(indegree[i] == 0){
                que.addLast(i);
            }
        }
        while(que.size() != 0){
            int idx = que.removeFirst();
            count++;
            ans.add(idx);

            for(int ele: graph[idx]){
                if(--indegree[ele] == 0){
                    que.addLast(ele);
                }
            }
        }
        int arr[] = new int[ans.size()];
        int k = 0;
        for(int i = ans.size() - 1; i >= 0; i--){
            arr[k++] = ans.remove(i);
        }
        int arr2[] = {};
        return count == numCourses ? arr : arr2;
    }
}