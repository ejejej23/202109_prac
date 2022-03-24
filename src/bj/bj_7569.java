package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato2 {
	int x;
	int y;
	int z;

	tomato2(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class bj_7569 {
	//토마토
	static int X;
	static int Y;
	static int Z;
	static int[][][] map;
	static int rowArr[] = {-1, 0, 1, 0, 0, 0};
	static int colArr[] = {0, 1, 0, -1, 0, 0};
	static int heightArr[] = {0, 0, 0, 0, 1, -1};
	static Queue<tomato2> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		Z = sc.nextInt();

		map = new int[Z][Y][X];
		q = new LinkedList<>();

		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					map[i][j][k] = sc.nextInt();
					if (map[i][j][k] == 1) q.offer(new tomato2(k, j, i));
				}
			}
		}

		System.out.println(bfs() + "\n");
	}

	static int bfs() {
		while (!q.isEmpty()) {
			tomato2 t2 = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = t2.x + rowArr[i];
				int ny = t2.y + colArr[i];
				int nz = t2.z + heightArr[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < X && ny < Y && nz < Z && map[nz][ny][nx] == 0) {
					map[nz][ny][nx] = map[t2.z][t2.y][t2.x] + 1;
					q.offer(new tomato2(nx, ny, nz));
				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					if (map[i][j][k] == 0) { // 하나라도 익지 않은 토마토
						return -1;
					}
					// 토마토가 익는데 걸리는 시간을 구함
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		if (result == 1) {
			return 0;
		} else {
			return result - 1;
		}
	}
}
