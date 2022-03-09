package bj;

import java.util.Scanner;

public class bj_14503 {
	//로봇청소기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();//0북 1동 2남 3서
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		int[][] map = new int[n][m];
		for(int i=0; i<n;i++){
			for(int j=0; j<m;j++){
				map[i][j] =sc.nextInt();
			}
		}

		int cl = 0;

		while (true){
			if(map[x][y] == 0) map[x][y] = 2;//청소했다는 뜻

			if(map[x+1][y] != 0 && map[x-1][y] != 0 && map[x][y+1] != 0 && map[x][y-1] != 0){
				//네방향 모두 청소됨 || 벽
				if(map[x-dx[d]][y-dy[d]] == 1){
					break;
				}else{
					x -= dx[d];
					y -= dy[d];
				}
			}else{
				d = (d+3)%4;
				if(map[x+dx[d]][y+dy[d]] == 0){
					x += dx[d];
					y += dy[d];
				}
			}
		}

		for(int i=0; i<n;i++){
			for(int j=0; j<m;j++){
				if(map[i][j] == 2) cl++;
			}
		}

		System.out.println(cl);
	}
}
