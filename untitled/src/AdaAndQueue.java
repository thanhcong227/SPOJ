import java.util.*;

public class AdaAndQueue {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> p = new ArrayDeque<>();
        int n = sc.nextInt();
        if (n>0) {
            char[] s = new char[n];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                s[0] = sc.next().charAt(0);
                if (s[0] == 't') {
                    int m;
                    m = sc.nextInt();
                    if (flag == 0) {
                        p.addFirst(m);
                    } else {
                        p.addLast(m);
                    }
                }
                if (s[0] == 'f') {
                    if (p.isEmpty()) {
                        System.out.println("No job for Ada?");
                    } else {
                        if (flag == 1) {
                            System.out.println(p.getLast());
                            p.removeLast();
                        } else {
                            System.out.println(p.getFirst());
                            p.removeFirst();
                        }
                    }
                }
                if (s[0] == 'b') {
                    if (p.isEmpty()) {
                        System.out.println("No job for Ada?");
                    } else {
                        if (flag == 1) {
                            System.out.println(p.getFirst());
                            p.removeFirst();
                        } else {
                            System.out.println(p.getLast());
                            p.removeLast();
                        }
                    }
                }
                if (s[0] == 'r') {
                    if (flag == 1) {
                        flag = 0;
                    } else if (flag == 0) {
                        flag = 1;
                    }
                }
                if (s[0] == 'p') {
                    int x;
                    x = sc.nextInt();
                    if (flag == 0) {
                        p.addLast(x);
                    } else {
                        p.addFirst(x);
                    }
                }
            }
        }
    }
}

