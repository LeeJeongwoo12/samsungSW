import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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

	static int N, W, H, WHOLE;
	static int MAX_BROKEN = 0;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int findTop(int[][] map, int col) {
		int top = -1;
		for (int i = 0; i < H; i++) {
			if (map[i][col] != 0) {
				top = i;
				break;
			}
		}
		return top;
	}

	static void dfs(int[][] board, int count, int broken, int[] course) {
		if (broken >= WHOLE) {
			MAX_BROKEN = broken;
			return;
		}

		// 구슬을 N번 떨어트림
		if (count >= N) {
			// 가장 많은 벽돌을 깬 경우를 찾음

			MAX_BROKEN = Math.max(MAX_BROKEN, broken);

			return;
		}

		for (int i = 0; i < W; i++) {
			// 가장 아래 칸이 0인 경우, 해당 열은 구슬을 떨어트릴 수 없음
			int top = findTop(board, i);
			if (top != -1) {
				int[][] temp = new int[H][W];
				boolean[][] visit = new boolean[H][W];
				boolean[] isBroken = new boolean[W];

				Queue<Point> q = new LinkedList<>();

				int curBroken = 1;

				course[count] = i;

				for (int j = 0; j < H; j++) {
					temp[j] = Arrays.copyOf(board[j], W);
				}

				q.offer(new Point(i, top));
				visit[top][i] = true;
				isBroken[i] = true;

				while (!q.isEmpty()) {
					Point p = q.poll();

					int power = temp[p.y][p.x];
					temp[p.y][p.x] = 0;

					for (int j = 0; j < 4; j++) {
						for (int k = 1; k <= power - 1; k++) {
							int nextX = p.x + k * dir[j][0];
							int nextY = p.y + k * dir[j][1];

							if (0 <= nextX && nextX < W && 0 <= nextY && nextY < H && temp[nextY][nextX] != 0
									&& !visit[nextY][nextX]) {
								q.offer(new Point(nextX, nextY));
								visit[nextY][nextX] = true;
								curBroken++;

								isBroken[nextX] = true;
							}
						}
					}
				}

				Stack<Integer> stk = new Stack<>();

				for (int j = 0; j < W; j++) {
					if (!isBroken[j])
						continue;

					for (int k = 0; k < H; k++) {
						if (temp[k][j] != 0) {
							stk.add(temp[k][j]);
						}
						temp[k][j] = 0;
					}

					int low = H - 1;
					while (!stk.isEmpty()) {
						temp[low--][j] = stk.pop();
					}
				}

				/*
				 * System.out.println(); for(int j=0;j<H;j++) {
				 * System.out.println(Arrays.toString(temp[j])); } System.out.println();
				 */

				dfs(temp, count + 1, broken + curBroken, course);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int test_case = nextInt();
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= test_case; t++) {
			sb.append("#").append(t).append(" ");

			MAX_BROKEN = 0;
			WHOLE = 0;

			N = nextInt();
			W = nextInt();
			H = nextInt();

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = nextInt();

					if (map[i][j] != 0) {
						WHOLE++;
					}
				}
			}

			dfs(map, 0, 0, new int[N]);

			sb.append(WHOLE - MAX_BROKEN).append("\n");
		}

		System.out.println(sb.toString());
	}
}
