package algorithm.recursion;

public class NQueens {

    private static final int N = 30;
    private static int cols[] = new int[N+1];

    private static boolean queens(int level){
        if(!promising(level)){
            return false;
        }else if(level == N){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    if(cols[i] == j){
                        System.out.print("1 ");
                    }else{
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
            return true;
        }else{
            for(int i = 1 ; i <= N ; i++){
                cols[level+1] = i;
                if(queens(level+1)){
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean promising(int level){
        for(int i = 1 ; i < level ; i++){
            if(cols[i] == cols[level]){
                return false;
            }else if(level-i == Math.abs(cols[i] - cols[level])){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        queens(0);
        System.out.println("end");
    }
}
