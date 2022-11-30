import java.util.Scanner;

public class SNTOFIBO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (isFibonacci(a) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            isFibonacci(a);
        }
    }

    public static boolean isFibonacci(int n) {
        int before = 0;
        int after = 1;
        int sum = 0;
        while (sum < n) {
            sum = before + after;
            before = after;
            after = sum;
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }
}

