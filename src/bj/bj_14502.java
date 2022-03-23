package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class dot {
	int y, x;

	public dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class bj_14502 {
	//연구소
	static int[][] map, copy;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int x, y, ans;
	static Queue<dot> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		copy = new int[y][x];
		q = new LinkedList<>();
		for (int i = 0; i < y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
//		wall(0, 0);
		wall(0);
		System.out.println(ans);
	}

//	public static void wall(int start, int depth) {
//		if (depth == 3) {
//			copy();
//			spread();
//			ans = Math.max(ans, countSafe());
//		}
//
//		for (int i = start; i < y * x; i++) {
//			int dy = i / x;
//			int dx = i % x;
//			if (map[dy][dx] == 1 || map[dy][dx] == 2) continue;
//
//			map[dy][dx] = 1;
//			wall(i + 1, depth + 1);
//			map[dy][dx] = 0;
//		}
//	}

	public static void wall(int cnt) {
        if (cnt == 3) { // 벽 3개 다 세웠을 경우
			copy();
            spread();  // 바이러스 퍼뜨리기
            ans = Math.max(ans, countSafe());    // 안전 영역 카운트
            return;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[j][i] == 0) {
                    map[j][i] = 1;
                    wall(cnt + 1);
                    map[j][i] = 0;
                }
            }
        }
    }

	static void spread() {
		while (!q.isEmpty()) {
			dot now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (nx >= 0 && nx < x && ny < y && ny >= 0) {
					if (copy[ny][nx] == 0) {
						copy[ny][nx] = 2;
						q.offer(new dot(ny, nx));
					}
				}
			}
		}
	}

	static int countSafe() {
		int cnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (copy[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

	static void copy() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				copy[i][j] = map[i][j];
				if(copy[i][j]==2) q.offer(new dot(i,j));
			}
		}
	}
}
