package bj;

import java.util.*;

public class bj_1260 {
    static boolean[] chk;
    static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        g = (ArrayList<Integer>[]) new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from].add(to);
            g[to].add(from);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(g[i]);
        }

        chk = new boolean[n+1];
        dfs(v);

        System.out.println();
        chk = new boolean[n+1];
        bfs(v);

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        chk[start] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            System.out.print(now +" ");
            for(int x : g[now]){
                if(!chk[x]){
                    chk[x] = true;
                    q.add(x);
                }
            }
        }
    }

    static void dfs(int start){
        if(chk[start]){
            return;
        }

        chk[start] = true;
        System.out.print(start +" ");

        for(int x : g[start]){
            if(!chk[x]){
                dfs(x);
            }
        }
    }
}
