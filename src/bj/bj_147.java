package bj;

import java.util.Scanner;

public class bj_147 {
	//수들의 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n=sc.nextLong();
		long sum=0;
		long cnt=0;

		for(int i=1; ; i++){
			if(sum> n) break;
			sum += i;
			cnt++;
		}
		System.out.println(cnt-1);
	}
}
