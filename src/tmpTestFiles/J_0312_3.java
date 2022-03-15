package tmpTestFiles;

import java.io.*;
import java.util.StringTokenizer;

public class J_0312_3 {
	static int[] stairs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(input1, " ");
		int k = Integer.parseInt(st1.nextToken());
		int n = Integer.parseInt(st1.nextToken());

		String input2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(input2, " ");
		stairs = new int[n+1];
		for(int i=0; i<n; i++){
	        stairs[i+1] = Integer.parseInt(st2.nextToken());
		}

		int min = 9;

		for(int i=9; i>0; i--){
			int cur = 1;
			int idx = 1;
			int cnt = k;
			while(true){
				int next = nextStairs(idx, cur, i);
				if(next== -1) break;
				cur = stairs[next];
				cnt--;

				if(cnt == 0){
					if(cur >= stairs[n]) min = i;
					break;
				}
			}
		}

		System.out.println(min);
	}

	static int nextStairs(int idx, int cur, int jmp){
		int newIdx = idx;
		for(int m=idx; m<stairs.length-1; m++){
			if(stairs[m+1] - stairs[m]> jmp) return -1;//점프 불가

			if(stairs[m+1] <= cur+ jmp){
				newIdx = m+1;
			}
		}
		return newIdx;
	}
}
