import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[][] count = new int[N][N];
			boolean[][] visit = new boolean[N][N];

			int answer = 0;

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '*') {
						int temp = 0;

						for (int k = 0; k < 8; k++) {
							int nextX = j + dir[k][0];
							int nextY = i + dir[k][1];

							if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
								if (map[nextY][nextX] == '*') {
									temp++;
								}
							}
						}

						count[i][j] = temp;
					} else {
						count[i][j] = -1;
						visit[i][j] = true;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (count[i][j] == 0 && !visit[i][j]) {
						Queue<Integer> xQ = new LinkedList<>();
						Queue<Integer> yQ = new LinkedList<>();

						answer++;

						xQ.offer(j);
						yQ.offer(i);
						visit[i][j] = true;

						while (!xQ.isEmpty()) {
							int x = xQ.poll();
							int y = yQ.poll();

							if (count[y][x] == 0) {
								for (int k = 0; k < 8; k++) {
									int nextX = x + dir[k][0];
									int nextY = y + dir[k][1];

									if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visit[nextY][nextX]) {
										if (count[nextY][nextX] > 0) {
											visit[nextY][nextX] = true;
										} else if (count[nextY][nextX] == 0) {
											visit[nextY][nextX] = true;
											xQ.offer(nextX);
											yQ.offer(nextY);
										}
									}
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j])
						answer++;
				}
			}

			sb.append(String.format("#%d %d\n", t, answer));
		}

		System.out.println(sb.toString());
	}
}
