package pushupman.D_Graph;

import java.util.Objects;

public class NumberOfIsland_DFS {

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
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int iLength = grid.length ;
        int jLength = grid[0].length ;
        if (
                i < 0 ||
                j < 0 ||
                iLength <= i ||
                jLength <= j ||
                grid[i][j] != '1'
        ) {
            return;
        }

        grid[i][j] = 'X';

        dfs(grid, i - 1, j); // 상
        dfs(grid, i + 1, j); // 하
        dfs(grid, i, j - 1); // 좌
        dfs(grid, i, j + 1); // 우

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
