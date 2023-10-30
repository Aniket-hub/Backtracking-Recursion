package Backtracking_Recursion;

import java.util.ArrayList;

public class MazeProblem {
    public static void main(String[] args) {
        // The Maze is of 3*3
        int result = countPaths(0,0); // starting point of the person is (0,0)
        System.out.println("Possible paths: "+result);
        // Printing the paths
        System.out.println("Printing Paths: ");
        printPaths("",0,0);
        System.out.println(printPathsRet("",0,0));
        // Including Diagonal Paths
        System.out.println(pathsDiagonal("",0,0));
    }

    static int countPaths(int row, int col) {
        if (row == 2 || col == 2) { //Base condition - as the maze is of 3*3
            return 1;
        }
        // There are two conditions - either P can move either right side or down side
        int leftCall = countPaths(row+1, col);
        int rightCall = countPaths(row, col+1);

        return leftCall+rightCall;
    }

    static void printPaths(String ans, int row, int col) {
        if (row == 2 && col == 2) {
            System.out.println(ans);
            return;
        }
        if (row < 2) {
            printPaths(ans+'V', row+1, col); // Down (Left) recursion call
        }
        if (col < 2) {
            printPaths(ans+'H',row,col+1);
        }
    }
    static ArrayList<String> printPathsRet(String ans, int row, int col) {
        if (row == 2 && col == 2) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row < 2) {
            list.addAll(printPathsRet(ans+'V', row+1, col)); // Down (Left) recursion call
        }
        if (col < 2) {
            list.addAll(printPathsRet(ans+'H',row,col+1));
        }
        return list;
    }

    static ArrayList<String> pathsDiagonal(String ans, int row, int col) {
        if (row == 2 && col == 2) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row < 2) {
            list.addAll(pathsDiagonal(ans+'V', row+1, col)); // Down (Left) recursion call
        }
        if (col < 2) {
            list.addAll(pathsDiagonal(ans+'H',row,col+1)); // V - Vertical, H - Horizontal
        }
        if (row < 2 && col < 2) {
            list.addAll(pathsDiagonal(ans+'D', row+1, col+1));
        }
        return list;
    }

}
