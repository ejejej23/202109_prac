package bj;

import java.util.Scanner;

public class bj_148 {
	//잃어버린 괄호
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] str = sc.nextLine().split("-");
		int sum = 0;
		for(int i=0; i<str.length; i++){
			int tmp = 0;

			String[] nums = str[i].split("\\+");
			for(int j=0; j<nums.length; j++){
				tmp += Integer.parseInt(nums[j]);
			}

			if(i == 0){
				sum = tmp;
			}else{
				sum -= tmp;
			}
		}
		System.out.println(sum);

	}
}
