package prg;

import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;

public class prg_0221_1 {
    public static int MAX = 1000000;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    static class Pair {
        int cur;
        int index;

        Pair(int cur, int index) {
            this.cur = cur;
            this.index = index;
        }
    }

    public static int solution(int[] numbers, int target) {
        //타겟넘버 bfs
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(numbers[0], 0));
        q.offer(new Pair(-numbers[0], 0));

        while (!q.isEmpty()){
            Pair p = q.poll();

            if(p.index == numbers.length-1){
                if(p.cur == target)
                    answer++;
                continue;
            }

            int c1 = p.cur + numbers[p.index+1];
            int c2 = p.cur - numbers[p.index+1];

            q.add(new Pair(c1,p.index+1));
            q.add(new Pair(c2,p.index+1));
        }

        return answer;
    }
}
