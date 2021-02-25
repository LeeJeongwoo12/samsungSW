import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];
			int sum = 0;
			int answer = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}

			int avg = sum / N;

			for (int i = 0; i < N; i++) {
				answer += Math.abs(avg - arr[i]);
			}
			
			answer /= 2;

			sb.append("#").append(t);
			sb.append(" ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
