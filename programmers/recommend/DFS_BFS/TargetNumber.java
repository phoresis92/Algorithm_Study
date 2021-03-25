package recommend.DFS_BFS;

import java.util.*;
/**
 * 문제 설명
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 입출력 예
 * numbers	target	return
 * [1, 1, 1, 1, 1]	3	5
 *
 * */
public class TargetNumber {

    public static void main (String[] arg){

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        TargetNumber targetNumber = new TargetNumber();

        System.out.println("targetNumber = " + targetNumber.solve(numbers, target));
    }

    public int dfs(int prev, int idx, int[] numbers, int target){
        if (numbers.length <= idx) {
            if (prev == target) {
                return 1;
            }
            return 0;
        }

        int number = numbers[idx];
        return dfs(prev + number, idx + 1, numbers, target)
                + dfs(prev - number, idx + 1, numbers, target);

    }

    static class Node {
        Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
        int value;
        int idx;
    }
    public int bfs(int[] numbers, int target) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, -1));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.idx == numbers.length-1){
                if(node.value == target){
                    answer++;
                }
                continue;
            }

            int nextIdx = node.idx + 1;
            queue.offer(new Node(node.value + numbers[nextIdx], nextIdx));
            queue.offer(new Node(node.value - numbers[nextIdx], nextIdx));
        }

        return answer;
    }

    public int solve(int[] numbers, int target){
//        return dfs(0, 0, numbers, target);
        return bfs(numbers, target);
    }

}
