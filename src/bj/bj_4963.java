package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair4 {
	int x;
	int y;

	Pair4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class bj_4963 {
	//섬
	static int cnt, w, h;
//	static int[] dx = {0, 0, 1, -1};
//	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {1, -1, 0, -1, 1, -1, 0, 1};
	static int[][] map;
	static boolean[][] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;

			map = new int[h][w];
			chk = new boolean[h][w];

			for (int m = 0; m < h; m++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < w; n++) {
					map[m][n] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for (int m = 0; m < h; m++) {
				for (int n = 0; n < w; n++) {
					if (!chk[m][n] && map[m][n] == 1) {
						bfs(m, n);
						cnt++;
					}
				}
			}
//			System.out.println(cnt);
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		Queue<Pair4> q = new LinkedList<Pair4>();
		q.offer(new Pair4(x, y));

		while (!q.isEmpty()) {
			Pair4 p = q.poll();
			x = p.x;
			y = p.y;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < h && ny >= 0 && ny < w && !chk[nx][ny] && map[nx][ny] == 1) {
					chk[nx][ny] = true;
					q.offer(new Pair4(nx, ny));
				}
			}
		}
	}
}