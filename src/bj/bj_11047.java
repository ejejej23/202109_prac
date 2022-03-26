package bj;

import java.util.Scanner;

public class bj_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int j=n-1; j>=0; j--){
            cnt += k/arr[j];
            k = k%arr[j];
        }

        System.out.println(cnt);
    }
}
