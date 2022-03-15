package tmpTestFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J_0312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] con = input.split(" ");

		String pwd = br.readLine();
		int len = Integer.parseInt(con[0]);
		int cmd = Integer.parseInt(con[1]);

		StringBuffer sb = new StringBuffer();

		for(int i=0; i<len;i++) {
			char ch = pwd.charAt(i);
			double chg = Math.pow(cmd, i + 1) % 26;
			double chkVal = ch + chg > 'z' ? ch + chg - 26 : ch + chg;

			sb.append((char) (chkVal));
		}

		System.out.println(sb);
	}
}
