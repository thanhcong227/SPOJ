import java.util.*;

public class EasyStack {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Long[] st = new Long[n];
        int e=0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                long k = sc.nextLong();
                if (k == 1) {
                    long h = sc.nextLong();
                    st[e]=h;
                    e++;
                } else if (k == 2) {
                    if (e!=0) {
                        e--;
                        st[e]=null;
                    }
                } else if (k == 3) {
                    if (e==0)
                        System.out.println("Empty!");
                    else
                        System.out.println(st[e-1]);
                }
            }
        }
    }
}