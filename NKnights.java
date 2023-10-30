package Backtracking_Recursion;


import java.util.Scanner;

public class NKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of N for N-Knights problem: ");
        int N = sc.nextInt();
        boolean[][] board = new boolean[N][N]; // Default values are false.. and are initialized values
        knight(board, 0, 0, N);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (col == board.length) {
            knight(board,row+1,0,knights);
            return;
        }
        if (row == board.length - 1 && col == board.length-1) { // If the column gets out of bound then just skip that step, that is simply return.
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board,row,col+1,knights-1);
            board[row][col] = false; // Backtracking
        }
        knight(board,row,col+1,knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Four place checks will occur for above rows
        // isValid checks whether the path/position during the check doesn't exceeds the boundaries
        if (isValid(board, row-2, col-1)) {
            if (board[row-2][col-1]) {
                return false;
            }
        }
        if (isValid(board, row-1, col-2)) {
            if (board[row-1][col-2]) {
                return false;
            }
        }
        if (isValid(board, row-1, col+2)) {
            if (board[row-1][col+2]) {
                return false;
            }
        }
        if (isValid(board, row-1, col-2)) {
            if (board[row-1][col-2]) {
                return false;
            }
        }
        return true;
    }

    //This function is created to not repeat the code for valid checcking
    static boolean isValid(boolean[][] board, int row, int col) { // It will check for valid conditions - that is things are out of bound or not
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }

}
