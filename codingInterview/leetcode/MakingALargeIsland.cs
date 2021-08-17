public class Solution {
    public int LargestIsland(int[][] grid) {
        int size = 0;
        for(int i = 0; i < grid.length)
        {
            for(int j = 0; j < grid[i].length)
            {
                if(gird[i][j] == 0)
                {
                    int[][] checkGrid = (int[][])gird.Clone();
                    checkGrid[i][j] = 1;
                    int checkSize = SizeIsland(chcekGrid);
                    
                    if (size < checkSize)
                    {
                        size = checkSize;
                    }
                }
            }
        }
    }
    
    public int SizeIsland(int[][] grid)
    {
        int size = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length)
            {
                
            }
        }
    }
}
