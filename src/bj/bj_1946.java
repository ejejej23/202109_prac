package bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Test implements Comparable<Test>{
	int x;
	int y;
	Test(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Test t){
		if(this.x > t.x) return 1;
		else return  -1;
	}
}

public class bj_1946 {
	//신입사원
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();

		while(n-- > 0){
			int person = sc.nextInt();

			List<Test> list = new ArrayList<>();
			for(int i=0; i<person; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();

				list.add(new Test(a,b));
			}

			Collections.sort(list);

			int ans = 1;
			int min = list.get(0).y;
			for(int i=1; i<person; i++){
				if(list.get(i).y < min){
					ans++;
					min = list.get(i).y;
				}
			}
			System.out.println(ans);
		}
	}
}
