package pushupman.D_Graph;

public class MaxOfIsland {

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {

        char[][] input =
                {
                        {'1', '1', '1', '0', '1'},
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '1'},
                        {'0', '1', '0', '0', '1'},
                };

        int myNumberOfIsland = myNumberOfIsland(input);
        System.out.println("myNumberOfIsland = " + myNumberOfIsland);

    }

    private static int myNumberOfIsland(char[][] input){
        int max = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                char c = input[i][j];

                if (c == '1') {
//                    max++;

                    int area = myNumberOfIsland(input, i, j, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    private static int myNumberOfIsland(char[][] input, int i, int j, int area){
        int iLength = input.length;
        int jLength = input[0].length;

        if (
                i < 0 ||
                j < 0 ||
                iLength <= i ||
                jLength <= j ||
                input[i][j] != '1'
        ) {
            return area;
        }

        input[i][j] = 'X';
        area++;

        for (int[] dir : dirs) {
            area = myNumberOfIsland(input, i + dir[0], j + dir[1], area);
        }

        return area;

    }

}
