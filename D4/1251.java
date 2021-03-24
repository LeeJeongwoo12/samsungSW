import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static double E;
	static double answer;
	static int[][] point;
	static ArrayList<Edge> edge;
	static int[] p;

	static class Edge implements Comparable<Edge> {
		int s, e; // start, end
		long w; // weight

		Edge() {
		}

		Edge(int s, int e, long w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}

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

		double nextDouble() throws Exception {
			return Double.parseDouble(br.readLine());
		}
	}

	static int find(int x) {
		if (p[x] == x)
			return x;

		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		p[y] = x;
	}

	static long getDist(int p1, int p2) {
		return (long) (Math.pow(point[p1][0] - point[p2][0], 2) + Math.pow(point[p1][1] - point[p2][1], 2));
	}

	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();
		StringBuilder sb = new StringBuilder();

		int test_case = sc.nextInt();

		for (int t = 1; t <= test_case; t++) {
			sb.append("#").append(t).append(" ");

			N = sc.nextInt();
			answer = 0;
			point = new int[N][2];
			edge = new ArrayList<>();
			p = new int[N];

			// x && y input
			for (int i = 0; i < N; i++) {
				point[i][0] = sc.nextInt();
				p[i] = i;
			}
			for (int i = 0; i < N; i++) {
				point[i][1] = sc.nextInt();
			}

			// E input
			E = sc.nextDouble();

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edge.add(new Edge(i, j, getDist(i, j)));
				}
			}

			Collections.sort(edge);

			int count = 0;

			for (int i = 0; i < edge.size(); i++) {				
				Edge cur = edge.get(i);

				if (find(cur.s) != find(cur.e)) {
					union(cur.s, cur.e);
					answer += cur.w * E;
					count++;
					
					if(count >= N)
						break;
				}
			}

			sb.append(String.format("%.0f", answer)).append("\n");
		}

		System.out.println(sb.toString());
	}
}
