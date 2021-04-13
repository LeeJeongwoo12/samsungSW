import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static class Pos {
		int x, y;

		Pos() {
		}

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		int test_case = nextInt();
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= test_case; t++) {
			sb.append("#").append(t).append(" ");

			int N = nextInt();
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
				Arrays.fill(dist[i], 9999999);
			}

			Queue<Pos> q = new LinkedList<>();
			q.offer(new Pos(0, 0));
			dist[0][0] = 0;

			while (!q.isEmpty()) {
				Pos cur = q.poll();
				int curCost = dist[cur.y][cur.x];

				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dir[i][0];
					int nextY = cur.y + dir[i][1];

					if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
						if (curCost + map[nextY][nextX] < dist[nextY][nextX]) {
							q.offer(new Pos(nextX, nextY));
							dist[nextY][nextX] = curCost + map[nextY][nextX];
						}
					}
				}
			}

			sb.append(dist[N - 1][N - 1]).append("\n");
		}

		System.out.println(sb.toString());
	}
}
