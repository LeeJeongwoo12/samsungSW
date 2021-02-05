import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			String s = br.readLine();
			int[] num = new int[2];

			num[0] = Integer.parseInt(s.substring(0, 2));
			num[1] = Integer.parseInt(s.substring(2, 4));

			boolean[] check = new boolean[2];

			if (1 <= num[0] && num[0] <= 12)
				check[0] = true;
			if (1 <= num[1] && num[1] <= 12)
				check[1] = true;

			sb.append("#").append(Integer.toString(t)).append(" ");

			if (check[0] && check[1]) {
				sb.append("AMBIGUOUS\n");
			} else if (check[0]) {
				sb.append("MMYY\n");
			} else if (check[1]) {
				sb.append("YYMM\n");
			} else {
				sb.append("NA\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
