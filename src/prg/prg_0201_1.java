package prg;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class prg_0201_1 {
	public static void main(String[] args) {
		int[] scoville = {12, 1, 2, 3, 8, 10};
		System.out.println(Solution.solution(scoville, 7));
	}

	static class Solution {
		public static int solution(int[] scoville, int K) {
			int answer = 0;
			/*

			boolean isOverK = Arrays.stream(scoville).allMatch(a -> (int) a >= K);
			if(isOverK) return 0;

			List<Integer> arr1 = Arrays.stream(scoville).sorted().limit(2).boxed().collect(Collectors.toList());
			List<Integer> arr2 = Arrays.stream(scoville).sorted().skip(2).boxed().collect(Collectors.toList());

			for (int i = 0; !isOverK; i++) {
				int mix = arr1.get(0) + (arr1.get(1) * 2);
				arr2.add(mix);
				answer++;
				isOverK = arr2.stream().allMatch(b-> b>=K);

				if(arr2.stream().count()<2){
                    if(isOverK) return answer;
                    else return -1;
                }

				arr1 = arr2.stream().sorted().limit(2).collect(Collectors.toList());
				arr2 = arr2.stream().sorted().skip(2).collect(Collectors.toList());
			}
			return answer;*/

			PriorityQueue<Integer> heap = new PriorityQueue<>();
			for(int i :scoville){
				heap.add(i);
			}

			while (heap.peek() <K){
				if(heap.size()<2) return -1;
				int h1 = heap.poll();
				int h2 = heap.poll();
				System.out.println(h1 +"   "+h2);

				int newNum = h1 +(h2*2);
				heap.offer(newNum);
				answer++;
			}

			return answer;
		}
	}
}
