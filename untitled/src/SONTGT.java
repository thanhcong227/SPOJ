import java.util.Scanner;

public class SONTGT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if(isFactorialPrime(number)==true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static boolean isFactorialPrime(int n) {
        int factorialPrime = 0;
        for (int i = 1; i < 8; i++) {
            if(factorial(i)+1==n || factorial(i)-1==n) {
                return true;
            }
        }
        return false;
    }

    public static int factorial(int n) {
        int a=1;
        for (int i = 1; i <= n; i++) {
            a *=i;
        }
        return a;
    }
}
