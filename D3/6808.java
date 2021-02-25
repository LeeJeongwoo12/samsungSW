import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] k;
	static int[] y;
	static int win;
	static int lose;
	static int[] arr;

	public static void dfs(int count, boolean[] visit) {
		if (count >= 9) {
			int k_score = 0;
			int y_score = 0;

			for (int i = 0; i < 9; i++) {
				if (k[i] > arr[i]) {
					k_score += k[i] + arr[i];
				} else
					y_score += k[i] + arr[i];
			}

			if (k_score > y_score)
				win++;
			else if (k_score < y_score)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[count] = y[i];
				dfs(count + 1, visit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			k = new int[9]; // 규영
			y = new int[9]; // 인영
			arr = new int[9];
			win = 0;
			lose = 0;
			boolean[] check = new boolean[18];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				k[i] = Integer.parseInt(st.nextToken());
				check[k[i] - 1] = true;
			}

			for (int i = 0, index = 0; i < 18 && index < 9; i++) {
				if (!check[i]) {
					y[index++] = i + 1;
				}
			}
			
			dfs(0, new boolean[9]);

			sb.append(String.format("#%d %d %d\n", t, win, lose));
		}

		System.out.println(sb.toString());
	}

}
