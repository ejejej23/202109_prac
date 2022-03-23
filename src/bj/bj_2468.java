package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair5 {
	int x;
	int y;

	Pair5(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class bj_2468 {
	//안전 영역
	static int[][] map;
	static boolean[][] chk;
	static int ans, n;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		HashMap<Integer, Integer> rain = new HashMap();
		rain.put(0, 0);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rain.put(map[i][j], map[i][j]);
			}
		}

		ans = 0;
		for (Integer r : rain.keySet()) {
			chk = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!chk[i][j] && map[i][j] > r) {
						bfs(i, j, r);
						cnt++;
					}
				}
			}
			if (cnt > ans) ans = cnt;
		}
		System.out.println(ans);
	}

	static void bfs(int x, int y, int r) {
		Pair5 p = new Pair5(x, y);
		Queue<Pair5> q = new LinkedList<>();
		q.offer(p);

		while (!q.isEmpty()) {
			Pair5 pp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pp.x + dx[i];
				int ny = pp.y + dy[i];
				if (nx >= 0 && nx < n && ny < n && ny >= 0 && !chk[nx][ny] && map[nx][ny] > r) {
					chk[nx][ny] = true;
					q.offer(new Pair5(nx, ny));
				}
			}
		}
	}
}
