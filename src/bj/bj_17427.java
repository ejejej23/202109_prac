package bj;

import java.util.Scanner;

public class bj_17427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		long gx = 0;

		for(int i=1; i<=a;i++){
			gx += (a/i)*i;
		}

		System.out.println(gx);
	}
}
