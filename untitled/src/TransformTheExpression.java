import java.util.Scanner;
import java.util.Stack;

public class TransformTheExpression {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String s;
        int i, tc;
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        while (tc-->0){
            s = sc.next();
            char[] u = s.toCharArray();
            for (i = 0; i < s.length(); i++) {
                if (u[i] == '(' || u[i] == '+' || u[i] == '-' || u[i] == '*' || u[i] == '/' || u[i] == '^') {
                    st.push(u[i]);
                } else if (u[i]==')') {
                    while (st.get(st.size()-1)!='(') {
                        System.out.print(st.get(st.size()-1));
                        st.pop();
                    }
                    st.pop();
                } else {
                    System.out.print(u[i]);
                }
            }
            System.out.println();
        }
    }
}