package bj;

import java.util.Scanner;

public class bj_1463 {
    public static int[] d;

    public static int go(int n) {
        if (n == 1) return 0;

        if (d[n] > 0) return d[n];

        d[n] = d[n - 1] + 1;

        if (n % 3 == 0) {
            int tmp = go(n / 3) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        if (n % 2 == 0) {
            int tmp = go(n / 2) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        return d[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];

        System.out.println(go(n));
    }
}
