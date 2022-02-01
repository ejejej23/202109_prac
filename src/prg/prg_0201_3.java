package prg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class prg_0201_3 {
	public static void main(String[] args) {
		//heap 이중우선순위큐 문제
		prg_0201_3 s = new prg_0201_3();
//		String[] oprations = {"I 7","I 5","I -5","D -1"};
		String[] oprations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] answer = s.solution(oprations);
		System.out.println(answer[0] + ","+answer[1]);
	}

	public int[] solution(String[] operations){
		int[] answer= new int[2];
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

		for (String operation : operations) {
			String[] str = operation.split(" ");

			switch (str[0]) {
				case "I" -> {
					min.offer(Integer.parseInt(str[1]));
					max.offer(Integer.parseInt(str[1]));
				}
				case "D" -> {
					if (max.isEmpty() || min.isEmpty()) continue;
					if (str[1].equals("1")) {
						int t = max.poll();
						min.remove(t);
					} else {
						int t = min.poll();
						max.remove(t);
					}
				}
			}
		}

		if(!max.isEmpty()){
			answer[0] = max.poll();
			answer[1] = min.poll();
		}
		return answer;
	}
}
