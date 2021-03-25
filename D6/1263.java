import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] people;
    static boolean[] visit;
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
            people = new int[N][N];
            answer = Integer.MAX_VALUE;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    people[i][j] = sc.nextInt();
                }
            }
 
            int sum = 0;
             
            for (int i = 0; i < N; i++) {
                Queue<Integer> p = new LinkedList<>();
                Queue<Integer> dist = new LinkedList<>();
                visit = new boolean[N];
                sum = 0;
 
                p.offer(i);
                dist.offer(0);
                visit[i] = true;
 
                while (!p.isEmpty()) {
                    int cur = p.poll();
                    int curD = dist.poll();
 
                    for (int j = 0; j < N; j++) {
                        if (!visit[j] && people[cur][j] == 1) {
                            p.offer(j);
                            dist.offer(curD + 1);
                            sum += curD + 1;
                            visit[j] = true;
                        }
                    }
                }
                 
                answer = answer > sum ? sum : answer;
            }
            sb.append(answer).append("\n");
        }
 
        System.out.println(sb.toString());
    }
}
