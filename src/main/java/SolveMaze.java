import edu.illinois.cs.cs125.lib.mazemaker.Maze;

import java.util.Random;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        Random ran = new Random();
        for (int step = 0; step < 100000; step++) {
            /*if(maze.isFinished())break;
            maze.turnLeft();
            if(maze.canMove()){
                maze.move();
                continue;
            }
            maze.turnRight();
            if(maze.canMove()){
                maze.move();
                continue;
            }
            maze.turnRight();
            if(maze.canMove()){
                maze.move();
                continue;
            }
            maze.turnRight();
            */
            if(maze.isFinished())break;
            while(maze.canMove()){
                maze.move();
                if(maze.isFinished())break;
            }
            if(maze.isFinished())break;
            if(ran.nextBoolean()){
                maze.turnLeft();
            }else{
                maze.turnRight();
            }
        }

        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }
    }
}
