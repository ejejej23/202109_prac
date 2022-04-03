package prg;

import java.util.ArrayList;
import java.util.List;

public class prg_0402_1 {
	//모든 순열
	public static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i - 1] >= a[i]) {
			i -= 1;
		}

		if (i <= 0) {
			return false;
		}

		int j = a.length - 1;
		while (a[j] <= a[i - 1]) {
			j -= 1;
		}

		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;

		j = a.length - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}

	static boolean chk(int[] a, int[][] dist) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {

				int distSum = 0;
				for (int k = 0; k < j - i; k++) {
					distSum += dist[a[i + k]][a[i + k + 1]];
				}
				if (distSum != dist[a[i]][a[j]]) return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		int[][] dist = {{0, 2, 3, 1}, {2, 0, 1, 1}, {3, 1, 0, 2}, {1, 1, 2, 0}};
		solution(dist);

	}

	static int[][] solution(int[][] dist) {
		int[][] answer = {};

		int len = dist[0].length;
		int[] a = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = i;
		}

		List<int[]> list = new ArrayList<>();
		do {
			if (chk(a, dist)) {
				int[] tmp = new int[len];
				for (int k = 0; k < len; k++) {
					tmp[k] = a[k];
				}
				list.add(tmp);
			}
//            System.out.println();
		} while (next_permutation(a));

		int size = list.size();
		answer = new int[size][];
		for (int i = 0; i < size; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
