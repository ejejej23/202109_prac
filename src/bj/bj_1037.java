package bj;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[t];

		for(int i=0; i<t; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		System.out.println(arr[0]*arr[t-1]);

	}
}
