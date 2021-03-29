package programmers.recommend.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Spicy {
    public static void main(String[] args) {
        Spicy spicy = new Spicy();

        int[] scoville = {1,2,3,9,10,12};
        int k = 7;

        int result = spicy.solve(scoville, k);

        System.out.println("result = " + result);

    }

    private int solve(int[] scoville, int k){


        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>();

        for(int sv : scoville){
            queue.offer(sv);
        }

        while(!isOver(queue, k)){
            if(queue.size() <= 1){
                answer = -1;
                break;
            }

            int first = queue.poll();
            int second = queue.poll();

            int newSv = calc(first, second);

            queue.offer(newSv);
            answer++;
        }

        return answer;
    }

    public boolean isOver(Queue<Integer> queue, int k){
        int sv = queue.peek();

        if(sv >= k){
            return true;
        }else{
            return false;
        }
    }

    public int calc(int first, int second){
        return first + (second * 2);
    }

}
