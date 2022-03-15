package kakao;

import java.util.HashMap;

public class Kakao_17_3 {
	//단체사진 찍기
	static int answer = 0;
	static HashMap<Character, Integer> map;
	static boolean[] visited;
	static int[] ch;
	static String[] d;

	public static void main(String args[]) {
		String[] data = new String[]{"N~F=0", "R~T>2"};
		System.out.println(solution(data));
	}

	public static int solution(String[] data) {
		visited = new boolean[8];
		ch = new int[8];
		d = data;
		map = new HashMap<>();

		map.put('A',0);
		map.put('C',1);
		map.put('F',2);
		map.put('J',3);
		map.put('M',4);
		map.put('N',5);
		map.put('R',6);
		map.put('T',7);
		dfs(0);

		return answer;
	}

	public static void dfs(int num){
		if(num == 8){
			if(chk()) answer++;
		}else{
			for(int i=0; i<8; i++){
				if(!visited[i]){
					visited[i] =true;
					ch[num] = i;
					dfs(num+1);
					visited[i]=false;
				}
			}
		}
	}

	public static boolean chk(){
		int a,b,res;
        char op;
        for(String s : d){
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4)-'0' + 1;

            if(op == '='){ if(Math.abs(a-b)!=res) return false;}
            else if(op == '>'){ if(Math.abs(a-b) <= res) return false;}
            else {if(Math.abs(a-b) >= res) return false;}
        }
        return true;
	}
}