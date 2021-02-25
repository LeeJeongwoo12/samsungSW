import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        Stack<Integer> st = new Stack<>();
 
        boolean flag = false;
 
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
 
                if ('0' <= ch && ch <= '9') {
                    if (flag) {
                        st.push(st.pop() * (ch - '0'));
                        flag = false;
                    } else {
                        st.push(ch - '0');
                    }
                } else if (ch == '*') {
                    flag = true;
                }
            }
 
            int sum = 0;
            while (!st.isEmpty()) {
                sum += st.pop();
            }
            sb.append(String.format("#%d %d\n", t, sum));
        }
         
        System.out.println(sb.toString());
    }
 
}
