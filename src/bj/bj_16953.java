package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16953 {
	//A -> B
	static int cnt = 0;
	static int b = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while (a!=b) {
			if (a > b) {
				System.out.println(-1);
				System.exit(0);
			}

			if (b % 10 == 1) b /= 10;
			else if (b % 2 == 0) b /= 2;
			else {
				System.out.println(-1);
				System.exit(0);
			}
			cnt++;
		}
		System.out.println(cnt+1);
	}

}
