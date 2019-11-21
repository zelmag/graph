class Solution {
    //is there a cycle? / circular dependency
    //using a topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> imPreReqTo = new HashMap<>();
        int[] indegrees = new int[numCourses]; //courses are 0 to n-1 so you can use course number as index
        for(int[] pr : prerequisites){
            int curr = pr[0];
            int prereq = pr[1];
            List<Integer> l = imPreReqTo.getOrDefault(prereq,new ArrayList<Integer>()); //add curr to list of prereq's imPreReqTo list
            l.add(curr);
            indegrees[curr]++; //bc prereq is pointing at you
            imPreReqTo.put(pr[1],l);
        }
        int visited = 0; 
        LinkedList<Integer> toVisit = new LinkedList<Integer>();
        //add all the initial nodes of 0 inDegree
        for(int i = 0; i < indegrees.length; i++){
                if(indegrees[i] == 0){
                    toVisit.add(i); //course if inDegree is zero
                }
        }
        while(!toVisit.isEmpty()){
            Integer curr = toVisit.poll();
            if(indegrees[curr] == 0){
                visited++;
            }
            //decrement all of classes that depend on me as a prereq by 1
            if(imPreReqTo.containsKey(curr)){
                for(Integer c : imPreReqTo.get(curr)){
                    indegrees[c]--;
                    if(indegrees[c] == 0){
                        toVisit.add(c);
                    }
                }
            }
        }
        if(visited < numCourses){
            return false; 
        }
        return true; 
    }
}
