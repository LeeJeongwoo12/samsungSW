import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static boolean[] visit;
    static int[][] mat;
    static int answer;
 
    static void dfs(int index, int count) {
        if (count >= N / 2) {
            int A = 0, B = 0, sum = 0;
            boolean flag = false;
 
            for (int i = 0; i < N; i++) {
                sum = 0;
                flag = visit[i];
 
                for (int j = 0; j < N; j++) {
                    if (i != j && flag == visit[j]) {
                        sum += mat[i][j];
                    }
                }
 
                if (flag) {
                    A += sum;
                } else {
                    B += sum;
                }
            }
 
            answer = Math.min(answer, Math.abs(A - B));
            return;
        }
 
        for (int i = index; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        Reader r = new Reader();
        StringBuilder sb = new StringBuilder();
 
        int test_case = r.nextInt();
 
        for (int t = 1; t <= test_case; t++) {
            N = r.nextInt();
 
            mat = new int[N][N];
            visit = new boolean[N];
            answer = 9999999;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = r.nextInt();
                }
            }
 
            dfs(0, 0);
            sb.append("#").append(t).append(" ");
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
 
class Reader {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
 
    Reader() {
    }
 
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
