class Solution {

    List<List<String>> result = new ArrayList<>();
    int[] x;   // x[i] = column of queen in row i

    public List<List<String>> solveNQueens(int n) {
        x = new int[n];        // 0-based indexing
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {       // full solution formed
            result.add(buildBoard(n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                x[row] = col;                 // place queen
                backtrack(row + 1, n);        // move to next row
            }
        }
    }

    // Mathematical pruning formula:
    // Conflict if:
    // 1) Same column: x[j] == col
    // 2) Diagonal: abs(x[j] - col) == abs(j - row)
    private boolean isSafe(int row, int col) {
        for (int j = 0; j < row; j++) {
            if (x[j] == col) return false;  // same column
            if (Math.abs(x[j] - col) == Math.abs(j - row)) return false;  // diagonal
        }
        return true;
    }

    private List<String> buildBoard(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rowArr = new char[n];
            Arrays.fill(rowArr, '.');
            rowArr[x[i]] = 'Q';
            board.add(new String(rowArr));
        }
        return board;
    }
}
