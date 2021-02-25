import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Hamburger implements Comparable<Hamburger>{
    int cal;
    int taste;
 
    Hamburger() {
    }
 
    Hamburger(int taste, int cal) {
        this.taste = taste;
        this.cal = cal;
    }
 
    @Override
    public int compareTo(Hamburger o) {
        return cal - o.cal;
    }
}
 
public class Solution {
    static int answer = 0;
    static boolean[] visit;
    static Hamburger[] h;
 
    public static void dfs(int index, int calSum, int tasteSum, int limit, int size) {
        for (int i = index + 1; i < size; i++) {
            if (!visit[i]) {
                if (calSum + h[i].cal <= limit) {
                    visit[i] = true;
                    answer = Math.max(answer, tasteSum + h[i].taste);
                    dfs(i, calSum + h[i].cal, tasteSum + h[i].taste, limit, size);
                    visit[i] = false;
                }
                else {
                    return;
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
 
        int test_case = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= test_case; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
 
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
 
            visit = new boolean[N];
 
            h = new Hamburger[N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
 
                h[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
             
            Arrays.sort(h);
             
            dfs(-1, 0, 0, L, N);
             
            sb.append("#").append(Integer.toString(t)).append(" ");
            sb.append(Integer.toString(answer)).append("\n");
        }
        System.out.println(sb.toString());
    }
 
}
