import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] cafe;
    static int[][] dir = { { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
    static int answer = -1;
    static int startX, startY;
    static boolean[] desert;
 
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
 
    static class Node {
        int x, y, move;
 
        Node() {
        }
 
        Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
 
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder sb = new StringBuilder();
 
        int test_case = sc.nextInt();
 
        for (int t = 1; t <= test_case; t++) {
            N = sc.nextInt();
 
            cafe = new int[N][N];
            answer = -1;
            desert = new boolean[101];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cafe[i][j] = sc.nextInt();
                }
            }
 
            for (int i = 0; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    startX = j;
                    startY = i;
                    desert[cafe[i][j]] = true;
                    search(j, i, 0, 1);
                    desert[cafe[i][j]] = false;
                }
            }
 
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb.toString());
    }
 
    public static void search(int x, int y, int move, int dist) {
        if (x == startX && y == startY && dist >= 4) {
            answer = answer > dist ? answer : dist;
            return;
        }
 
        for (int i = move; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
 
            if (nextX == startX && nextY == startY) {
                search(nextX, nextY, i, dist);
                return;
            }
 
            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !desert[cafe[nextY][nextX]]) {
                desert[cafe[nextY][nextX]] = true;
                search(nextX, nextY, i, dist + 1);
                desert[cafe[nextY][nextX]] = false;
            }
        }
    }
}
