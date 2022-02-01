package prg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class prg_0201_2 {
	public static void main(String[] args) {
		//heap 디스크 컨트롤러 문제
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int[][] jobs = {{1, 9}, {2, 6}, {1, 3}};
		prg_0201_2 s = new prg_0201_2();
		System.out.println(s.solution(jobs));
	}

	public int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]){
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
		});//도착순 정렬

		int cnt = 0;
		int time = 0;

		PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int i = 0;
		while (cnt < jobs.length) {
			while (i < jobs.length && jobs[i][0] <= time) {
				qu.offer(jobs[i++]);//time 까지 요청된 일들을 저장
			}

			if (qu.isEmpty()) {
				time++;
			} else {
				int[] tmp = qu.poll();
				answer += (tmp[1] + time - tmp[0]);
				time += tmp[1];
				cnt++;
			}
		}

		return answer / jobs.length;
	}
}
