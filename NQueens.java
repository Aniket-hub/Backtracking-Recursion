package Backtracking_Recursion;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of N for N-Queens problem: ");
        int N = sc.nextInt();
        boolean[][] board = new boolean[N][N]; // Default values are false.. and are initialized values
        System.out.println("Total no of ways: " + queens(board,0));
    }

    static int queens(boolean[][] board, int row) { // We are starting the col from 0 every time.. so doesn't make sense to pass in the argument
        if (row == board.length) { // Base condition
            display(board);
            System.out.println();
            return 1; // It returns 1 to ensure that 1 possible answer is found
        }

        //Placing the queen and checkin for each row & col
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            //Place the queen if it is safe place
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row+1);
                // When you come out of this function call.. change back to normal
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // First check for the upward direction
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;  // If any of block in upward direction is true, i.e., If there is a Queen, then its not safe and return false.
            }
        }
        // Check for Diagonal Left direction
        int maxLeftDiagonalBlocksCanGo = Math.min(row, col);
        for (int i = 1; i <= maxLeftDiagonalBlocksCanGo; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
        // Check for Diagonal Right direction
        int maxRightDiagonalBlocksCanGo = Math.min(row, board.length-col-1); // -col is to exclude the left cols from boards.length, -1 is to exclude the current block in the path
        for (int i = 1; i <= maxRightDiagonalBlocksCanGo; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }

        return true; // If none of the conditions returns false.. then the position is safe and returns true.
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q  ");
                }
                else {
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }

}
