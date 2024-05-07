import java.util.*;

public class NQueens {

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean solveNQueensUtil(int[][] board, int row, int n) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (solveNQueensUtil(board, row + 1, n)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (!solveNQueensUtil(board, 0, n)) {
            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Solution:");
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
          System.out.println("Enter the no of Queens: ");
          int n=sc.nextInt();
         // Board size
        solveNQueens(n);
    }
}
