package bj;

import java.util.Scanner;

public class bj_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int answer=0;

		if (num ==4 || num == 7) {
			answer = -1;
		}else if(num%5 ==0){
			answer = num/5;
		}else if(num%5 == 1 || num%5 == 3){
			answer = num/5+1;
		}else if(num%5 == 2 || num%5 == 4){
			answer = num/5+2;
		}

		System.out.println(answer);
	}
}
