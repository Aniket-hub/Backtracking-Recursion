package Backtracking_Recursion;

public class MazeWithObstacles {
    public static void main(String[] args) {
        // The maze is of 3*3
        boolean[][] maze = { // Obstacle is at (1,1)
                {false,false,false},
                {false,true,false},
                {false,false,false}
        };
        pathWithObstacles("",0,0,maze);
    }

    static void pathWithObstacles(String ans, int row, int col, boolean[][] maze) {
        if (row == maze.length-1 && col == maze[0].length-1) { // Base condition
            System.out.println(ans);
            return;
        }
        if (maze[row][col]) { // Condition for obstacle
            return;
        }
        if (row < maze.length-1) {
            pathWithObstacles(ans+'V', row+1, col, maze);
        }
        if (col < maze[0].length-1) {
            pathWithObstacles(ans+'H', row, col+1, maze);
        }
    }

}
