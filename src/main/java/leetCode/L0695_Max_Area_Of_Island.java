package leetCode;

/**
 * 最大岛屿面积
 */
public class L0695_Max_Area_Of_Island {
    int rows = 0;
    int cols = 0;
    public int maxAreaOfIsland(int[][] grid) {
        //排除特殊情况
        if(grid == null || grid.length<=0 || grid[0].length <=0){
            return 0;
        }

        rows = grid.length;
        cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                maxArea = Math.max(maxArea,dfs(grid,i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if(x <0|| x >= rows || y <0 ||y >= cols || grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        return 1+dfs(grid,x+1,y)+dfs(grid,x-1,y)+dfs(grid,x,y-1)+dfs(grid,x,y+1);
    }


}
