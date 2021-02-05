import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int answer_count;
	static int answer_number;
	static int size;

	public static void dfs(int[][] arr, boolean[][] visit, int[][] count, int x, int y) {
		int nextX = 0, nextY = 0;
		for (int i = 0; i < 4; i++) {
			nextX = x + dir[i][0];
			nextY = y + dir[i][1];

			if (0 <= nextX && nextX < size && 0 <= nextY && nextY < size) {
				if (arr[nextY][nextX] == arr[y][x] + 1) {
					if (!visit[nextY][nextX]) {
						dfs(arr, visit, count, nextX, nextY);
					}
					count[y][x] = count[nextY][nextX] + 1;
					visit[y][x] = true;
					
					if(answer_count < count[y][x]) {
						answer_count = count[y][x];
						answer_number = arr[y][x];
					}
					if(answer_count == count[y][x]) {
						answer_number = answer_number > arr[y][x] ? arr[y][x] : answer_number;
					}
				}
			}
		}
		
		if(!visit[y][x]) {
			visit[y][x] = true;
			count[y][x] = 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			boolean[][] visit = new boolean[size][size];
			int[][] count = new int[size][size];
			answer_count = 0;
			answer_number = 99999999;

			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (!visit[i][j]) {
						dfs(arr, visit, count, j, i);
					}
				}
			}
			sb.append("#").append(Integer.toString(t)).append(" ");
			sb.append(Integer.toString(answer_number)).append(" ").append(Integer.toString(answer_count)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
