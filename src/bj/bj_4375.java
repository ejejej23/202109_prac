package bj;

import java.util.Scanner;

public class bj_4375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;

		while(sc.hasNextInt()){
			a= sc.nextInt();

			int num = 0;

			for(int i=1; ;i++){
				num = num*10 +1;
				num %= a;
				if(num%a == 0){
					System.out.println(i);
					break;
				}
			}
		}

	}
}
