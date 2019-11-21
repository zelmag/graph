//count number of islands. BFS style. Using queues instead of bfs using the stack
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    //mark this and all the connected land plots as counted 
                    bfs(r,c,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void bfs(int r, int c, char[][] grid){
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] coord = q.poll();
            int currR = coord[0];
            int currC = coord[1];
            grid[currR][currC] = '0';
            //mark as visited
            //add its neighbors to the queue
            int[][] changes = new int[][]{ {1,0},{-1,0},{0,-1},{0,1}};
            //r+1, c
            // r-1,c
            //r,c-1
            //r, c+1
            for(int i = 0; i < changes.length; i++){
                int newR = currR + changes[i][0];
                int newC = currC + changes[i][1];
                boolean validCoor = (newR >=0 && newR<grid.length) && (newC >=0 && newC<grid[0].length);
                if(validCoor && grid[newR][newC] == '1'){
                    q.add(new int[]{newR,newC});
                    grid[newR][newC] = '0';
                }
            }
        }
    }
}
