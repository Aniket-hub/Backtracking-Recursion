package Backtracking_Recursion;

import java.util.Arrays;

public class MazeWithAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = { // No obstacle present now
                {false,false,false},
                {false,false,false},
                {false,false,false}
        };
        allDirectionMovements("",0,0,maze);
        int[][] path = new int[maze.length][maze[0].length];
        allDirectionPathPrint("",0,0, maze, path,1);
    }

    static void allDirectionMovements(String ans, int row, int col, boolean[][] maze) {
        if (row == maze.length-1 && col == maze[0].length-1) { // Base condition
            System.out.println(ans);
            return;
        }

        if (maze[row][col]) { // Condition for obstacle or visited cells
            return;
        }

        // Considering the block in the current path
        maze[row][col] = true;

        if (row < maze.length-1) { // Down Movement
            allDirectionMovements(ans+'D', row+1, col, maze);
        }
        if (row > 0) { // Up Movement
            allDirectionMovements(ans+'U', row-1, col, maze);
        }
        if (col > 0) { // Left Movement
            allDirectionMovements(ans+'L', row, col-1, maze);
        }
        if (col < maze[0].length-1) { // Right Movement
            allDirectionMovements(ans+'R', row, col+1, maze);
        }

        // The function will over here, so before function gets removed, revert the changes in the maze that were made by the function
        maze[row][col] = false;

    }

    static void allDirectionPathPrint(String ans, int row, int col, boolean[][] maze, int[][] path, int step) {
        if (row == maze.length-1 && col == maze[0].length-1) { // Base condition
            path[row][col] = step; // The last step will also be a step
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("Path: "+ans);
            System.out.println();
            return;
        }

        if (maze[row][col]) { // Condition for obstacle or visited cells
            return;
        }

        // Considering the block in the current path
        maze[row][col] = true;
        path[row][col] = step;

        if (row < maze.length-1) { // Down Movement
            allDirectionPathPrint(ans+'D', row+1, col, maze, path, step+1);
        }
        if (row > 0) { // Up Movement
            allDirectionPathPrint(ans+'U', row-1, col, maze, path, step+1);
        }
        if (col > 0) { // Left Movement
            allDirectionPathPrint(ans+'L', row, col-1, maze, path, step+1);
        }
        if (col < maze[0].length-1) { // Right Movement
            allDirectionPathPrint(ans+'R', row, col+1, maze, path, step+1);
        }

        // The function will over here, so before function gets removed, revert the changes in the maze that were made by the function
        maze[row][col] = false;
        path[row][col] = 0;

    }

}
