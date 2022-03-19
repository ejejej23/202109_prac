package bj;

import java.util.Scanner;

public class bj_10162 {
	//전자레인지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (((n % (5 * 60)) % 60) % 10 == 0) {
			int[] answers = new int[3];

			answers[0] = n / (5 * 60);
			answers[1] = (n % (5 * 60)) / 60;
			answers[2] = ((n % (5 * 60)) % 60) / 10;

			System.out.println(answers[0] + " " + answers[1] + " " + answers[2]);
		} else {
			System.out.println(-1);
		}


	}
}
