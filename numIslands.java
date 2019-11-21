//count number of islands. 
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    //mark this and all the connected land plots as counted 
                    islands+=dfs(r,c,grid);
                }
            }
        }
        return islands;
    }
    public int dfs(int r, int c, char[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            //stop. marking. this is either not a valid cell or its a 0
            return 0;
        }
        grid[r][c] = '0'; //mark self
        dfs(r-1,c,grid); //mark up
        dfs(r+1,c,grid); //mark down
        dfs(r,c+1,grid); //mark right
        dfs(r,c-1,grid); //mark left
        return 1; //for the original island
    }
}
