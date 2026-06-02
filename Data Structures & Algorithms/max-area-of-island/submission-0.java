class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        int maxIsland = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int islandSize = dfs(grid, r, c, visited);
                    maxIsland = Math.max(maxIsland, islandSize);
                }
            }
        }
        return maxIsland;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int count = 1;

        // 4 possible directions
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int[] d : dirs) {
            count += dfs(grid, r + d[0], c + d[1], visited);
        }

        return count;
    }
}
