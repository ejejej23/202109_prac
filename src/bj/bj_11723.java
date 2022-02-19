package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		int n = 20;
		int x;

		while (t-- > 0) {
			String[] str = br.readLine().split(" ");

			switch (str[0]) {
				case "add":
					x = Integer.valueOf(str[1]) - 1;
					ans = (ans | (1 << x));
					break;
				case "remove":
					x = Integer.valueOf(str[1]) - 1;
					ans = (ans & ~(1 << x));
					break;
				case "check":
					x = Integer.valueOf(str[1]) - 1;
					int chk = (ans & (1 << x));
					if (chk == 0) sb.append("0\n");
					else sb.append("1\n");
					break;
				case "toggle":
					x = Integer.valueOf(str[1]) - 1;
					ans = (ans ^ (1 << x));
					break;
				case "all":
					ans = (1 << n) - 1;
					break;
				case "empty":
					ans = 0;
					break;
			}

		}
		System.out.println(sb);

	}
}
