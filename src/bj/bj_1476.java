package bj;

import java.util.Scanner;

public class bj_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		int y = 1;
		int e = 1;
		int s = 1;
		int m = 1;
		while (true){
			if(E == e && S == s && M == m){
				System.out.println(y);
				break;
			}
			if(e<15) e++;
			else e = 1;

			if(s<28) s++;
			else s = 1;

			if(m<19) m++;
			else m=1;

			y++;
		}
	}
}
