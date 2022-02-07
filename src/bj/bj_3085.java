package bj;

import java.util.Scanner;

public class bj_3085 {
	static int chk(char[][] a, int start_row, int end_row, int start_col, int end_col){
		int answer=0;
		int n = a.length;

		for(int i=start_row; i<=end_row; i++){
			int cnt = 1;
			for(int j=1; j<n; j++){
				if(a[i][j] == a[i][j-1]) cnt++;
				else cnt =1;

				if(answer<cnt) answer = cnt;
			}
		}

		for(int i=start_col; i<=end_col; i++){
			int cnt =1;
			for(int j=1; j<n; j++){
				if(a[j][i] == a[j-1][i]) cnt++;
				else cnt = 1;

				if(answer<cnt) answer = cnt;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] a = new char[n][n];
		for(int i=0; i<n; i++){
			a[i] = sc.next().toCharArray();
		}

		int answer =0;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(j+1<n){
					char t = a[i][j];
					a[i][j] = a[i][j+1];
					a[i][j+1] = t;

					int tmp = chk(a, i,i,j,j+1);
					if(answer<tmp) answer= tmp;

					t = a[i][j];
					a[i][j] = a[i][j+1];
					a[i][j+1] = t;
				}

				if(i+1<n){
					char t = a[i][j];
					a[i][j] = a[i+1][j];
					a[i+1][j] = t;

					int tmp = chk(a, i, i+1, j,j);
					if(answer<tmp) answer= tmp;

					t = a[i][j];
					a[i][j] = a[i+1][j];
					a[i+1][j] = t;
				}
			}
		}
		System.out.println(answer);
	}
}
