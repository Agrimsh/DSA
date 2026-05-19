class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i< prerequisites.length;i++){
            int a= prerequisites[i][0];
            int b= prerequisites[i][1];

            adj.get(a).add(b);
           
        }

        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[numCourses];
        for(int i=0;i<adj.size();i++){
            for(int neigh:adj.get(i)){
                indegree[neigh]++;
            }
        }  

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                
            }
        } 

        int count=0;

        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;

                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return count == numCourses;
    }
}