package prg;

import java.util.HashSet;
import java.util.Iterator;

public class prg_0205_2 {
	public static void main(String[] args) {
		prg_0205_2 s = new prg_0205_2();
		String numbers = "17";
		System.out.println(s.solution(numbers));
	}

	public int solution(String numbers) {
		int answer=0;
		HashSet<Integer> set = new HashSet<>();
		prmt("", numbers, set);

		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			int n = it.next();
			if(isPrime(n)) {
				answer++;
			}
		}

		return answer;
	}

	public void prmt(String pre, String str, HashSet<Integer> set){
		if(!pre.equals(""))
			set.add(Integer.valueOf(pre));

		for(int i=0; i<str.length(); i++){
			prmt(pre+str.charAt(i), str.substring(0,i)+str.substring(i+1),set);
		}
	}

	public boolean isPrime(Integer num){
		if(num == 0|| num == 1) return false;
		else {
			for(int i=2; i<=Math.sqrt(num); i++){
				if(num%i == 0) return false;
			}
		}
		return true;
	}
}
