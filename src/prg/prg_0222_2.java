package prg;

public class prg_0222_2 {
    static boolean[] chk;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        chk = new boolean[n];
        for(int i=0; i<n; i++){
            if(!chk[i]){
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    public static int dfs(int[][] computers, int n){
        //네트워크문제 dfs
        chk[n] = true;

        for(int i=0; i<computers.length; i++){
            if(!chk[i] && computers[n][i] == 1){
                dfs(computers, i);
            }
        }

        return 0;
    }
}
