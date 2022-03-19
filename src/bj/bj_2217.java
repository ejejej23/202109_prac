package bj;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2217 {
	//로프
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] ropes = new int[n];
		for(int i=0; i<n; i++){
			ropes[i] = sc.nextInt();
		}
		Arrays.sort(ropes);

		int max = ropes[n-1];

		for(int i=n-1; i>=0; i--){
			int tmp =0;
			tmp = ropes[i]*(n-i);
			if(tmp> max) max = tmp;
		}
		System.out.println(max);
	}
}
