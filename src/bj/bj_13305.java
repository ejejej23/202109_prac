package bj;

import java.util.Scanner;

public class bj_13305 {
	//주유소
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		long[] oil = new long[c];
		long[] load = new long[c-1];
		for(int i=0; i<c-1; i++){
			load[i] = sc.nextLong();
		}
		for(int i=0; i<c; i++){
			oil[i] = sc.nextLong();
		}


		long tmp = oil[0];
		long cost = 0;

		for(int i=0; i<c-1; i++){
			if(oil[i]<=tmp) tmp = oil[i];
			cost += tmp*load[i];
		}

		System.out.println(cost);
	}
}
