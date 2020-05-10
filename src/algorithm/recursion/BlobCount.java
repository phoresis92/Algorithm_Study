package algorithm.recursion;

public class BlobCount {


    private static final int N = 8;

    private static final int [][] pixel = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };

    private static final int CHECKED = 2;

    private static int isBlob (int x, int y){
        if(x < 0 || y <0 || x >= N || y >= N){
            return 0;

        }else if(pixel[x][y] != 1){

            return 0;

        }else {

            pixel[x][y] = CHECKED;

            return 1 + isBlob(x-1, y+1) + isBlob(x, y+1) + isBlob(x+1, y+1)
                    + isBlob(x-1, y) + isBlob(x+1, y)
                    + isBlob(x-1, y-1) + isBlob(x, y-1) + isBlob(x+1, y-1);

        }
    }

    public static void main(String[] args) {
        System.out.println(isBlob(7, 1));


        System.out.println(Math.max(1, 3));
    }

}
