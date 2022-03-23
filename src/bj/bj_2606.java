package bj;

import java.io.IOException;
import java.util.Scanner;

public class bj_2606 {
	//바이러스
	static boolean[] chk;
	static int[][] arr;
	static int nodeCnt;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		nodeCnt = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[nodeCnt+1][nodeCnt+1];
		chk = new boolean[nodeCnt+1];
		while (m-- > 0){
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(1);
		System.out.println(cnt);
	}
	static void dfs(int start){
		chk[start]=true;
		for(int i=1; i<=nodeCnt;i++) {
			if(arr[start][i] ==1 && !chk[i]){
				dfs(i);
				cnt++;
			}
		}
	}
}
