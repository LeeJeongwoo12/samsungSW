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
			sb.append("#").append(Integer.toString(t)).append("\n");
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			int[][] sum = new int[4][n + 1];

			for (int i = 1; i <= n; i++) {
				int input = Integer.parseInt(br.readLine());
				
				for(int j=1;j<=3;j++) {
					sum[j][i] = sum[j][i - 1];
				}
				
				sum[input][i]++;
			}

			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				for (int j = 1; j <= 3; j++) {
					sb.append(Integer.toString(sum[j][r] - sum[j][l - 1])).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
