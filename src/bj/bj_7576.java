package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    int x;
    int y;
    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bj_7576 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Tomato> q = new LinkedList<Tomato>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
                dist[i][j] = -1;
                if(a[i][j] == 1){
                    q.add(new Tomato(i,j));
                    dist[i][j] = 0;
                }

            }
        }
        //토마토 세팅됨

        while (!q.isEmpty()){
            Tomato t = q.remove();
            int x = t.x;
            int y = t.y;

            for(int i=0; i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 &&nx<n && ny<m){
                    if(a[nx][ny] == 0 && dist[nx][ny] == -1){
                        q.add(new Tomato(nx,ny));
                        dist[nx][ny] = dist[x][y]+1;
                    }
                }
            }
        }

        //가장작은 경우의 수 또는 토마토가 없는 경우 찾기기
       int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (ans < dist[i][j]) {
                    ans = dist[i][j];
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);

    }
}