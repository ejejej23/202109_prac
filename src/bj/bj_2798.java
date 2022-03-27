package bj;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2798 {
	//블랙잭
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] card = new int[n];
		for(int i=0; i<n; i++){
			card[i] = sc.nextInt();
		}

		int tmp =0;
		int rslt =0;
		Arrays.sort(card);
		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					tmp = card[i]+card[j] + card[k];
					if(tmp==m){
						System.out.println(m);
						System.exit(0);
					}else if(tmp <m && tmp > rslt){
						rslt = card[i]+card[j] + card[k];
					}
				}
			}
		}
		System.out.println(rslt);
	}
}
