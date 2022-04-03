package kakao;

public class Kakao_20_1 {
	public static void main(String[] args) {
//		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
		String s = "abcabcdede";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = s.length();

		if(s.length() == 0) return 0;

		for (int i = 1; i < s.length()/2+1; i++) {
			answer  = Math.min(answer, chkRule(s, i));
		}

		return answer;
	}

	static int chkRule(String s, int n) {
		StringBuilder sb = new StringBuilder();
		int dup = 1;
		String p1 = s.substring(0, n);
		int cnt = s.length() % n == 0? s.length()/n : s.length()/n+1;
		for (int i = n, j = 1; j <= cnt; i += n, j++) {
			if (j == cnt) {
				sb.append(dup == 1 ? p1 : (dup + p1));
				break;
			}
			String p2 = s.substring(i, (i + n) > s.length() ? s.length() :i+n);

			if (p1.equals(p2)) {
				dup++;
			} else {
				sb.append(dup == 1 ? p1 : (dup + p1));
				p1 = p2;
				dup = 1;
			}
		}
		return sb.length();
	}
}
