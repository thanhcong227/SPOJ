import java.util.Scanner;

public class SLPLN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(max(a));
        }
    }

    public static int max(int a) {
        int max =1;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if(i*i*i<=a) {
                max = Math.max(max,i);
            }
        }
        return max;
    }
}
