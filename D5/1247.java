import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	Pos() {
	}

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Reader {
	BufferedReader br;
	StringTokenizer st;

	Reader() {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
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

public class Solution {
	static int N;
	static Pos home, company;
	static ArrayList<Pos> list;
	static int answer;

	static int getDist(Pos cur, Pos next) {
		return Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);
	}

	static void dfs(Pos cur, int dist, int count, boolean[] visit) {
		if (count == N) {
			dist = dist + getDist(cur, company);
			
			answer = answer < dist ? answer : dist;
			return;
		}

		Pos next;

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				next = list.get(i);
				visit[i] = true;
				dfs(next, dist + getDist(cur, next), count + 1, visit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		int test_case = reader.nextInt();

		for (int t = 1; t <= test_case; t++) {
			N = reader.nextInt();

			home = new Pos(reader.nextInt(), reader.nextInt());
			company = new Pos(reader.nextInt(), reader.nextInt());
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				list.add(new Pos(reader.nextInt(), reader.nextInt()));
			}

			answer = Integer.MAX_VALUE;

			dfs(home, 0, 0, new boolean[N]);

			sb.append("#").append(t).append(" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
