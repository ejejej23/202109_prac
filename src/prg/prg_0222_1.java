package prg;

import java.util.LinkedList;
import java.util.Queue;

public class prg_0222_1 {
    static boolean[] chk;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n, computers));
    }

    public static void bfs(int[][] computers, int n){
        //네트워크문제 bfs
        Queue<Integer> q= new LinkedList<>();
        q.add(n);
        chk[n] =true;

        while (!q.isEmpty()){
            int now = q.remove();
            for(int i=0; i<computers.length; i++){
                if(!chk[i] && computers[now][i] == 1 && now !=i){
                    chk[i]= true;
                    q.offer(i);
                }
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        chk = new boolean[n];
        for(int i=0; i<n; i++){
            if(!chk[i]){
                bfs(computers, i);
                answer++;
            }
        }

        return answer;
    }
}
