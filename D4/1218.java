import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        final int test_case = 10;
 
        for (int t = 1; t <= test_case; t++) {
            br.readLine();
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
 
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
 
                if (ch == '(' || ch == '[' || ch == '{' || ch == '<')
                    st.add(ch);
                else if (ch == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        flag = false;
                        break;
                    }
                    st.pop();
                } else if (ch == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        flag = false;
                        break;
                    }
                    st.pop();
                } else if (ch == '}') {
                    if (st.isEmpty() || st.peek() != '{') {
                        flag = false;
                        break;
                    }
                    st.pop();
                } else {
                    if (st.isEmpty() || st.peek() != '<') {
                        flag = false;
                        break;
                    }
                    st.pop();
                }
            }
 
            sb.append("#".concat(Integer.toString(t)));
 
            if (!flag || !st.isEmpty()) {
                sb.append(" 0\n");
            } else {
                sb.append(" 1\n");
            }
        }
        System.out.println(sb.toString());
    }
 
}
