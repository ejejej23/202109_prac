package bj;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] smlPrsn = new int[9];

		int t = 9;
		while (t > 0) {
			smlPrsn[--t] = sc.nextInt();
		}

		Arrays.sort(smlPrsn);
		int length = smlPrsn.length;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += smlPrsn[i];
		}

		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (sum - smlPrsn[i] - smlPrsn[j] == 100) {
					for(int k=0; k<length; k++){
						if(i == k || j == k) continue;
						System.out.println(smlPrsn[k]);
					}
					System.exit(0);
				}
			}
		}

	}
}
