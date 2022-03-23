package bj;

import java.util.Scanner;

public class bj_1012 {
	//유기농 배추
	static int cnt=0;
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0){
			n = sc.nextInt();
			m = sc.nextInt();
			int k = sc.nextInt();

			map = new int[n][m];
			chk = new boolean[n][m];
			for(int i=0; i<k; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();

				map[a][b] = 1;
			}
			cnt =0;
			for(int i=0;i<n;i++){
				for(int j=0; j<m; j++){
					if(map[i][j] == 1 && !chk[i][j]){
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void dfs(int a, int b){
		chk[a][b] = true;

		for(int i=0; i<4; i++){
			int x = a + dx[i];
			int y = b + dy[i];
			if(x < n && x>=0 && y <m && y>=0 && map[x][y] == 1 && !chk[x][y]){
					dfs(x,y);
				}
		}

	}
}
