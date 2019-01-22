package codingInterviewJava;

//Todo need to commment out package
// or install Eclipse support for VS code

class NumOfIsland {

    public static void main(String[] args) {

        NumOfIsland nIsland = new NumOfIsland();
        int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        System.out.println(nIsland.countIsland(grid));
    }

    public int countIsland(int[][] grid) {

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

    public int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // out of bounce
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (visited[row][col] == true || grid[row][col] == 0)
            return 0;
        visited[row][col] = true;

        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        return 1;

    }
}