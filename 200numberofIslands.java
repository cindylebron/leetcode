class Solution {
    /**
     * DFS solution: Time Complexity: O(mn)
     *  Space Complexity:
            Input Space: O(mn)
            Auxiliary Space: O(depth) => O(mn * memory for each call) => O(mn)
                - O(mn * memory for each call): For call-stack, in the worst
                case, it could be all 1s. Each recursive call might take some
                more space.
            Total Space => Input + Auxiliary
                        => O(mn) + O(mn * memory for each call)
                        => O(mn * memory for each call)
                        => O(mn)
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        
        // if grid is empty, return 0
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        // number of islands
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    count += 1;
                }
            }
        }
        return count; 
    }
    private void markIsland(char[][] grid, int x, int y) {
        //base cases
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1')
            return;
        
        // mark x,y as visited using '2'
        grid[x][y] = '2';
        
        // make recursive calls in four adjacent directions
        markIsland(grid, x-1, y);
        markIsland(grid, x+1, y);
        markIsland(grid, x, y+1);
        markIsland(grid, x, y-1);
    }
}


class Solution {
    /**
     * BFS solution: Time Complexity: O(mn)
     *  Space Complexity:
            Input Space: O(mn)
    */
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int rows = grid.length;
        // if grid is empty, return 0
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        // number of islands
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    grid[i][j] = '#';
                    queue.offer(new int[]{i,j});
                    BFS(grid, queue);
                }
            }
        }
        return count; 
    }
    private void BFS(char[][] grid, Queue<int[]> queue) {
        int[][] dirs = new int[][] {
            {1,0}, {0,1}, {-1,0}, {0,-1}};
        //store the item in a queue, and poll each after you finish visited
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            //go right, down, left, up
            for (int[] dir: dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1')
                    continue;
                grid[x][y] = '#';
                queue.offer(new int[]{x,y});
            }
        }
    }
}