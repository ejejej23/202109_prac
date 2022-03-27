package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_7568 {
	//덩치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] person = new int[t][2];

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			person[i][1] = Integer.parseInt(st.nextToken());
			person[i][0] = Integer.parseInt(st.nextToken());
		}


		for (int i = 0; i < t; i++) {
			int rank = 1;
			for (int j = 0; j < t; j++) {
				if (i == j) continue;
				if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) rank++;
			}
			System.out.print(rank + " ");
		}

	}
}
