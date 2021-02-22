package pushupman.D_Graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class NumberOfIsland_BFS {

    public static void main(String[] args) {
        char[][] input =
                {
                        {'1', '1', '1', '0', '1'},
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '1'},
                        {'0', '0', '0', '0', '1'},
                };

        print(input);

        int result = solve(input);

        print(input);
        System.out.println("result = " + result);
    }

    private static int solve(char[][] grid) {
        int count = 0;

        if (
                Objects.isNull(grid) ||
                grid.length == 0 ||
                grid[0].length == 0
        ) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    count++;
//                    myBfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static void bfs(char[][] grid, int i, int j){
        int iLength = grid.length;
        int jLength = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int ii = poll[0];
                int jj = poll[1];

                grid[ii][jj] = 'X';

                for (int[] direction : directions) {
                    int nextI = ii + direction[0];
                    int nextJ = jj + direction[1];

                    if(
                            nextI >= 0 &&
                            nextJ >= 0 &&
                            nextI < iLength &&
                            nextJ < jLength &&
                            grid[nextI][nextJ] == '1'
                    ) {
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }

            }
        }
    }

    private static void myBfs(char[][] grid, int i, int j) {
        int iLength = grid.length;
        int jLength = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ii = poll[0];
            int jj = poll[1];
            if (
                    ii < 0 ||
                    jj < 0 ||
                    ii >= iLength ||
                    jj >= jLength
//                   || grid[ii][jj] != '1'
            ) {
                continue;
            }
            char c = grid[ii][jj];
            if (c == '1') {
                grid[ii][jj] = 'X';
                queue.offer(new int[]{ii - 1, jj});
                queue.offer(new int[]{ii + 1, jj});
                queue.offer(new int[]{ii, jj - 1});
                queue.offer(new int[]{ii, jj + 1});
            }
        }

    }

    public static void print(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
