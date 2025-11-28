class Solution {
    int result = 0;
    int count = 1;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int start = 0;
        int start2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    start = i;
                    start2 = j;
                }

                if (grid[i][j] ==0) {
                    count++;
                }
            }
        }
        

        backtrack(grid, start, start2, 1);

        return result;
    }

    public void backtrack(int[][] grid, int i, int j, int visitedZeros) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (visitedZeros == count) {
                result++;
            }
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = -1; 

        
        if (temp == 0) {
            visitedZeros++;
        }

        backtrack(grid, i + 1, j, visitedZeros);
        backtrack(grid, i - 1, j, visitedZeros);
        backtrack(grid, i, j + 1, visitedZeros);
        backtrack(grid, i, j - 1, visitedZeros);

        grid[i][j] = temp; 
    }
}
