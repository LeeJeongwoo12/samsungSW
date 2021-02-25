import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
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

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String s = sc.next();
			Stack<Character> st = new Stack<>();
			StringBuilder temp = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (!st.isEmpty()) {
					if (st.peek() == ch)
						st.pop();
					else
						st.push(ch);
				} else {
					st.push(ch);
				}
			}
			
			while(!st.isEmpty()) {
				temp.append(st.pop());
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(temp.reverse().toString()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
