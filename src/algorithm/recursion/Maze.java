package algorithm.recursion;

/**
 * 1) 현재 위치가 출구이거나
 * 2) 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나
 *
 * boolean findPath(x, y)
 *  if(x, y) is either on the wall or a visited cell
 *      return false;
 *  else if(x, y) is the exit
 *      return true;
 *  else
 *      mark(x, y) as a visited cell;
 *      for each neighbouring cell (x', y') of (x, y) do
 *          if(findPath(x', y'))
 *              return true;
 *      return false;
 *
 * */

public class Maze {

    private static final int N = 8;

    private static final int [][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };

    // 안가본 경로
    private static final int PATHWAY = 0;
    // 벽
    private static final int WALL = 1;
    // 길없음
    private static final int BLOCK = 2;
    // 경로
    private static final int PATH = 3;
    // 출구
    private static final int EXIT = 4;

    private static void printMaze (){
        System.out.println("======================================");

        for(int i = 0 ; i < maze.length ; i++){
            for(int j = 0 ; j < maze[i].length ; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

        System.out.println("======================================");

    }

    private static boolean solveMaze(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N){
            // 유효성 검사

            return false;

        }else if(maze[x][y] != PATHWAY){
            // 안가본 경로가 아닐경우

            return false;

        }else if(x == N-1 && y == N-1){
            // 출구일 경우
            maze[x][y] = EXIT;
            return true;

        }else {
            // 새로운 길 탐색

            // 마킹
            maze[x][y] = PATH;

            if(solveMaze(x, y+1) || solveMaze(x+1, y) || solveMaze(x, y-1) || solveMaze(x-1, y)){
                return true;
            }
            maze[x][y] = BLOCK;
            return false;

        }
    }

    public static void main(String[] args) {
        printMaze();
        solveMaze(0, 0);
        printMaze();
    }
}
