package bj;

import java.io.*;
import java.util.StringTokenizer;

public class bj_4796 {
	//캠핑
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int caseCnt = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) break;
			int cnt = 0;

			cnt = (c / b * a) + (c % b > a ? a : c % b);

			bw.write("Case " + caseCnt++ + ": " + cnt + "\n");

		}
		bw.flush();
	}
}
