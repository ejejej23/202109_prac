package bj;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1339 {
	//수학
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alp = new int[26];
		int ans = 0;

		int t = sc.nextInt();
		String[] strArr = new String[t];

		for (int i = 0; i < t; i++) {
			strArr[i] = sc.next();
		}

		for (int i = 0; i < t; i++) {
			int tmp = (int) Math.pow(10, strArr[i].length() - 1);
			for (int j = 0; j < strArr[i].length(); j++) {
				alp[(int) strArr[i].charAt(j) - 65] += tmp;
				tmp /= 10;
			}
		}

		Arrays.sort(alp);

		int index = 9;
		int sum = 0;
		for (int i = alp.length - 1; i >= 0; i--) {
			if (alp[i] == 0) continue;
			sum += alp[i] * index--;
		}

		System.out.println(sum);
	}
}
