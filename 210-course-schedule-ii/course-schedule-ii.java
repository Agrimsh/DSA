class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i< prerequisites.length;i++){
            int a= prerequisites[i][0];
            int b= prerequisites[i][1];

            adj.get(b).add(a);
           
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

        ArrayList<Integer>ans=new ArrayList<>();

        while(!q.isEmpty()){
            int curr=q.poll();                             
            ans.add(curr);
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;                         // Topological sort

                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(ans.size()!=numCourses){
            return new int[]{};
        }

        int result[] = new int[numCourses];    //Arraylist to Array conversion

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
        
    }
}