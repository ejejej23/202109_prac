package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int dir; // 레이저의 현재 방향
	int mirror; // 현재 위치까지 설치된 거울의 개수

	Point(int x, int y, int dir, int mirror) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.mirror = mirror;
	}
}

public class bj_6087 {
    static Point startPoint, endPoint;
	static int W, H;
	static int min = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.valueOf(st.nextToken());
        H = Integer.valueOf(st.nextToken());

		map = new char[W][H];

		for(int i=0; i<H;i++){
			String str = br.readLine();
			for(int j=0; j<W;j++){
				map[i][j] = str.charAt(j);

				if(map[i][j] == 'C'){
					if(startPoint == null){
						startPoint = new Point(i,j,-1,0);
					}else{
						endPoint = new Point(i,j,-1,0);
					}
				}
			}
		}

		bfs();

		System.out.println(min);
    }

	public static void bfs(){
		Queue<Point> q = new LinkedList<>();
		q.add(startPoint);

		visited = new int[W][H];
		visited[startPoint.x][startPoint.y] = 1;

		while(!q.isEmpty()){
			Point p = q.remove();
			int px = p.x;
			int py = p.y;
			int pd = p.dir;
			int pm = p.mirror;

			if(px == endPoint.x && py == endPoint.y){
				min = Math.min(min, pm);
				continue;
			}

			for(int i=0; i<4;i++){
				int nx = px + dx[i];
				int ny = py + dy[i];
				int nd = i;

				if(nx<0 || ny<0 || nx>=H || ny >=W || map[nx][ny] == '*') continue;

				int nm = pm;

				if(pd != -1 && pd != nd){
					nm +=1;
				}

				if(visited[nx][ny] == 0){
					visited[nx][ny] = nm;
					q.add(new Point(nx,ny,nd,nm));
				}else if(visited[nx][ny] >= nm){
					visited[nx][ny] = nm;
					q.add(new Point(nx,ny,nd,nm));
				}
			}

		}
	}
}