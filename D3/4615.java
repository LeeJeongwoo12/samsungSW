import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int black;
	static int white;
	static int[][] board;
	static int N, M;

	static int[][] dir = { { -1, -1 }, { -1, 1 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { 1, 1 }, { 1, 0 } };

	static class Reader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void changeColor(int x, int y, int color, int move) {
		int nextX = x;
		int nextY = y;
		boolean flag = false;
		ArrayList<Point> list = new ArrayList<>();

		while (true) {
			nextX += dir[move][0];
			nextY += dir[move][1];

			if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N || board[nextY][nextX] == 0)
				break;

			if (board[nextY][nextX] == board[y][x]) {
				flag = true;
				break;
			}

			list.add(new Point(nextX, nextY));
		}

		if (flag) {
			for (int i = 0; i < list.size(); i++) {
				Point temp = list.get(i);
				board[temp.y][temp.x] = board[y][x];
			}
			
			if(color == 1) {
				black += list.size();
				white -= list.size();
			}
			else {
				white += list.size();
				black -= list.size();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();
		StringBuilder sb = new StringBuilder();

		int test_case = sc.nextInt();

		for (int t = 1; t <= test_case; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			board = new int[N][N];

			black = 2;
			white = 2;

			board[(N - 1) / 2][(N - 1) / 2] = 2;
			board[(N - 1) / 2][(N - 1) / 2 + 1] = 1;
			board[(N - 1) / 2 + 1][(N - 1) / 2] = 1;
			board[(N - 1) / 2 + 1][(N - 1) / 2 + 1] = 2;

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int color = sc.nextInt();

				board[y][x] = color;
				
				if(color == 1)
					black++;
				else
					white++;

				for (int j = 0; j < 8; j++) {
					int nextX = x + dir[j][0];
					int nextY = y + dir[j][1];

					if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && board[nextY][nextX] != board[y][x]) {
						changeColor(x, y, color, j);
					}
				}
			}

			sb.append(String.format("#%d %d %d\n", t, black, white));
		}

		System.out.println(sb.toString());
	}
}
