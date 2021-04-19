import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());
		long mod = 1234567891;
		
		long[] factorial = new long[1000001];
		factorial[0] = 1;
		factorial[1] = 1;

		for (int i = 2; i < 1000001; i++) {
			factorial[i] = ((factorial[i - 1]) * i) % mod;
		}

		for (int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long factN = factorial[N] % mod;
			long factNR = (factorial[R] * factorial[N - R]) % mod;
			long powerNR = 1;
			
			long count = mod - 2;
			
			while(count > 0) {
				if(count % 2 == 1) {
					powerNR *= factNR;
					powerNR %= mod;
				}
				
				factNR = factNR * factNR % mod;
				count /= 2;
			}
						
			long answer = (factN * powerNR) % mod;
			
			sb.append(String.format("#%d %d\n", t, answer));
		}

		System.out.println(sb.toString());
	}
}
