package codingInterviewJava;

class NumOfIsland {

    public static void main(String[] args) {

        int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(int[][] grid) {

        int numsOfRow = grid.length;
        int numsOfCol = grid[0].length;
        boolean[][] visited = new boolean[numsOfRow][numsOfCol];

        int count = 0;
        int total = 0;
        for (int row = 0; row < numsOfRow; row++) {
            for (int col = 0; col < numsOfCol; col++) {
                count = dfs(grid, row, col, visited);
                // System.out.println(count);
                if (count > 0) {
                    total++;
                }
            }
        }

        return total;

    }

    public static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // out of bounce
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (visited[row][col] == true || grid[row][col] == 0)
            return 0;
        visited[row][col] = true;

        // return 1
        // + dfs(grid, row, col+1, visited)
        // + dfs(grid, row, col-1, visited)
        // + dfs(grid, row+1, col, visited)
        // + dfs(grid, row-1, col, visited);

        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        return 1;

    }
}