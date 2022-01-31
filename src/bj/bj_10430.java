package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_10430 {
        public static void main(String[] args) throws IOException {
                //방법1
                /*Scanner input = new Scanner(System.in);

                int a= input.nextInt();
                int b= input.nextInt();
                int c= input.nextInt();

                input.close();

                System.out.println((a+b)%c);
                System.out.println(((a%c) +(b%c))%c);
                System.out.println((a*b)%c);
                System.out.println(((a%c)*(b%c))%c);*/

                //방법2
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, "");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                System.out.println((a+b)%c);
                System.out.println(((a%c) +(b%c))%c);
                System.out.println((a*b)%c);
                System.out.println(((a%c)*(b%c))%c);
        }
}
