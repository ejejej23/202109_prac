package kakao;

public class Kakao_20_1_1 {
	public static void main(String[] args) {
		String s = "abcabcdede";
		System.out.println(solution(s));
	}

	static int solution(String s) {
		int min = s.length();
		int len = s.length() / 2 + 1;
		for (int i = 1; i < len; i++) {
			String before = "";
			int sum = 0;
			int cnt = 1;
			for (int j = 0; j < s.length(); ) {
				int start = j;
				j = (j + i > s.length()) ? s.length() : j + i;
				String temp = s.substring(start, j);
				if (temp.equals(before)) {
					cnt++;
				} else {
					if (cnt != 1) {
						sum += (int) Math.log10(cnt) + 1;
					}
					cnt = 1;
					sum += before.length();
					before = temp;
				}
			}
			sum += before.length();
			if (cnt != 1) {
				sum += (int) Math.log10(cnt) + 1;
			}
			min = (min > sum) ? sum : min;
		}

		return min;
	}
}
