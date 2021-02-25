import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			int sum = 0;
			int start = N / 2;
			int end = N / 2;

			for (int i = 0; i < N; i++) {
				String s = br.readLine();

				if (i >= N / 2)
					flag = false;

				for (int j = start; j <= end; j++) {
					sum += s.charAt(j) - '0';
				}

				if (flag) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}

			sb.append(String.format("#%d %d\n", t, sum));
		}
		System.out.println(sb.toString());
	}
}
