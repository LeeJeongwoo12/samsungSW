import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int diffX = Math.abs(x1 - x2);
			int diffY = Math.abs(y1 - y2);

			int answer = 0;

			if (diffX == diffY) {
				answer = diffX + diffY;
			} else {
				answer = diffX > diffY ? diffX * 2 : diffY * 2;

				if ((diffX + diffY) % 2 == 1) {
					answer -= 1;
				}
			}

			sb.append(String.format("#%d %d\n", t, answer));
		}
		System.out.println(sb.toString());
	}
}
