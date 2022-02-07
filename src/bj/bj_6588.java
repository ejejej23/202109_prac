package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_6588 {
	static int MAX = 1000000;
	static List<Integer> primeArr = new ArrayList<>();
	static boolean[] chk = new boolean[MAX+1];

	public static void main(String[] args) {
		bj_6588 b = new bj_6588();
		b.findPrime(MAX);

		Scanner sc = new Scanner(System.in);

		while (true){
			int n = sc.nextInt();
			if( n == 0) break;

			int size = primeArr.size();
			for(int i=1; i<size; i++){
				int p = primeArr.get(i);
				if(!chk[n-p]) {
					System.out.println(n +" = "+ p + " + " + (n-p));
					break;
				}
			}
		}
	}

	public void findPrime(int num){
		//소수가 아닌 경우 0으로 표기. 0,1은 소수가 아님
		chk[0] = chk[1] = true;

		for(int i=2; i*i<num; i++){
			if(chk[i] == true) continue;

			primeArr.add(i);
			for(int j=i*i;j<=num; j+=i) chk[j] = true;//어떤 수의 배수는 소수가 아니므로 제외
			//각 배수를 지우기 때문에 i의 제곱수부터 배수를 지우면 된다.
			// 그 앞의 수는 지워져있을것
		}
	}
}
