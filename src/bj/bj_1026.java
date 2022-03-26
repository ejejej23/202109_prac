package bj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }


        for(int i=0; i<n; i++){
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (arr1[i] * arr2[i]);
        }

        System.out.println(ans);

    }
}
