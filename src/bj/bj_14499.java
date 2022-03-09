package bj;

import java.util.Scanner;

public class bj_14499 {
	//주사위 굴리기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int K = sc.nextInt();

		int[][] map = new int[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
			}
		}

		int[] dice = new int[7];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		while(K-- > 0){
			int k = sc.nextInt()-1;
			int nx = X +dx[k];
			int ny = Y +dy[k];

			if(nx<0 || nx>N || ny<0 || ny>M) continue;

			int temp;
			switch (k){
				case 0://동
					temp = dice[1];
	                dice[1] = dice[4];
	                dice[4] = dice[6];
	                dice[6] = dice[3];
	                dice[3] = temp;
					break;
				case 1://서
					temp = dice[1];
	                dice[1] = dice[3];
	                dice[3] = dice[6];
	                dice[6] = dice[4];
	                dice[4] = temp;
					break;
				case 2://남
					temp = dice[1];
	                dice[1] = dice[5];
	                dice[5] = dice[6];
	                dice[6] = dice[2];
	                dice[2] = temp;
					break;
				case 3://북
					temp = dice[1];
	                dice[1] = dice[2];
	                dice[2] = dice[6];
	                dice[6] = dice[5];
	                dice[5] = temp;
					break;
			}
			X = nx;
			Y = ny;

			if(map[X][Y] == 0){
				map[X][Y] = dice[6];
			}else{
				dice[6] = map[X][Y];
				map[X][Y] = 0;
			}

			System.out.println(dice[1]);
		}

	}
}
