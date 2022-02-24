package bj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1];
        boolean[] chk = new boolean[n+1];

        for(int i=1; i<=n; i++){
            g[i] = new ArrayList<>();
        }

        for(int j=0; j<m; j++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);
        }

        chk[0]=true;
        int cnt = 0;

        for(int i=1; i<=n;i++){
            if(!chk[i]){
                bfs(g, chk, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int bfs(ArrayList<Integer>[] g, boolean[] chk, int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        while (!q.isEmpty()){
            int now = q.remove();
            chk[now] = true;

            int len = g[now].size();
            for(int i=0; i< len;i++){
                int t = g[now].get(i);
                if(!chk[t]){
                    chk[t] = true;
                    q.add(t);
                }
            }
        }

        return 0;
    }
}
