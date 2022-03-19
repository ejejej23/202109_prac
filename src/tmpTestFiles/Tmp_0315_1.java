package tmpTestFiles;

import java.util.Scanner;

public class Tmp_0315_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		String[] str = s.split(":");

		System.out.println(Integer.parseInt(str[1]));

	}

}
