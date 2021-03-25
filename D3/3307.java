import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] num;
    static int[] dp;
    static int answer;
 
    static class Reader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() throws Exception {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
 
        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
 
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder sb = new StringBuilder();
 
        int test_case = sc.nextInt();
 
        for (int t = 1; t <= test_case; t++) {
            sb.append("#").append(t).append(" ");
 
            N = sc.nextInt();
            num = new int[N];
            dp = new int[N];
            answer = 0;
 
            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
                dp[i] = 1;
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (num[j] < num[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                         
                        answer = answer > dp[i] ? answer : dp[i];
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
