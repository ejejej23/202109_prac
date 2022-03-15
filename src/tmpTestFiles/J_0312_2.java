package tmpTestFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Toilet{
	boolean isUse;
	int endTime;

	Toilet(boolean isUse, int endTime){
		this.isUse = isUse;
		this.endTime = endTime;
	}
}

public class J_0312_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] user = new int[num][2];

		for(int i=0; i<num; i++){
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());

			user[i][0] = b;
			user[i][1] = c;
		}

		Arrays.sort(user, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]){
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});//종료시간순 정렬, 그다음 시작시간별 정렬

		System.out.println(maxToiletUserCnt(user));
		System.out.println(minToiletCnt(user));
	}

	static int maxToiletUserCnt(int[][] user){
		int maxUserCnt = 0;
		int time = 0;

		for(int i=0; i<user.length; i++){
			if(time<= user[i][0]){
				time = user[i][1];
				maxUserCnt++;
			}
		}
		return maxUserCnt;
	}

	static int minToiletCnt(int[][] user){
		int userCnt = 0;
		int time = 0;
		ArrayList<Toilet> toilet = new ArrayList<>();
		while (true) {
			for(int j=0; j<user.length;j++){
				if(user[j][0] == time){
					boolean flag = true;
					for(Toilet t : toilet){
						if(t.endTime <= time) t.isUse = false;

						if(!t.isUse){
							t.isUse =true;
							t.endTime = user[j][1];
							flag = false;
							userCnt++;
							break;
						}
					}

					if(flag){
						toilet.add(new Toilet(true, user[j][1]));
						userCnt++;
					}
				}
			}
			time++;
			if(userCnt == user.length) break;
		}
		return toilet.size();
	}
}
