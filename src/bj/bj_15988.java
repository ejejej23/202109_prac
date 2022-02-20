package bj;

import java.util.Scanner;

public class bj_15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1000001];
        d[0] = 1;
        long mod = 1000000009;

        for(int i=1; i<=1000000; i++){
            for(int j=1; j<=3;j++){
                if(i-j>=0) d[i] = d[i-j];
            }

            d[i] %= mod;
        }
        System.out.println(d[n]);
    }
}
