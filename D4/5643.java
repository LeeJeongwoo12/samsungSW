import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			int[][] graph = new int[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;

				graph[x][y] = 1;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (graph[i][k] != 0 && graph[k][j] != 0) {
							graph[i][j] = 1;
						}
					}
				}
			}

			int answer = 0;
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				flag = true;
				for (int j = 0; j < N; j++) {
					if(i == j)
						continue;
					
					if(graph[i][j] == 0 && graph[j][i] == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag)
					answer++;
			}
			
			sb.append(String.format("#%d %d\n", t, answer));
		}
		
		System.out.println(sb.toString());
	}
}
