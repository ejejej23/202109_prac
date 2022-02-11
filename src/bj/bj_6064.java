package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(bf.readLine());

		while(t-- >0){
			String[] str = bf.readLine().split(" ");
			int M = Integer.valueOf(str[0]);
			int N = Integer.valueOf(str[1]);

			int x = Integer.valueOf(str[2])-1;
			int y = Integer.valueOf(str[3])-1;

			boolean isFind = false;
			int ans = 0;

			for(int k=x;k<=M*N; k+=M){
				if(k%N == y){
					ans = k+1;
					isFind = true;
					break;
				}
			}

			if(isFind) System.out.println(ans);
			else System.out.println(-1);
		}

	}
}
