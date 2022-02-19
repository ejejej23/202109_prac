package bj;

import java.io.IOException;
import java.util.Scanner;

public class bj_11052 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= i; j++) {
                if (d[i] < d[i - j] + a[i]) d[i] = d[i - j] + a[i];
            }
        }
        System.out.println(d[n]);
    }
}
