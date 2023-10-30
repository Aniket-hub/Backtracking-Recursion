package Backtracking_Recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (solveSudoku(board)) {
            display(board);
        }
        else {
            System.out.println("Can't be solved!");
        }
    }

    static boolean solveSudoku(int[][] board) {
        int len = board.length;
        int row = -1;
        int col = -1; // initially row and col = -1
        boolean emptyItemLeft = true; // Initially lets it is true

        // This is how we are replacing the r,c from arguments
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 0) { // Means I found an empty item
                    row = i;
                    col = j;
                    emptyItemLeft = false;
                    break; // As I have found one of the possible answers
                }
            }
            // After traversing the entire row if I found some empty element in the row then break.
            if (emptyItemLeft == false) {
                break;
            }
        }
        if (emptyItemLeft == true) {
            return true; // Means sudoku is solved
        }
        // End

        // After this lets backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board,row,col,number)) {
                board[row][col] = number; // This might be false answer
                if (solveSudoku(board)) {
                    // found the answer
                    return true;
                }
                else {
                    // Backtrack
                    board[row][col] = 0;
                }
            }
        }
        // After doing everything if you can't find the answer then return false.
        // That is, Sudoku can't be solved.
        return false;

    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check for row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // Check for column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col %  sqrt);
        // Check for Subgrid box
        for (int r = rowStart; r < rowStart+sqrt; r++) {
            for (int c = colStart; c < colStart+sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        // If everything is okay not returning false, then return true
        return true;
    }

    static void display(int[][] board) {
        for (int[] row: board) {
            for (int num : row) {
                System.out.print(num+"  ");
            }
            System.out.println();
        }
    }

}
