import java.util.Scanner;

public class MainCard {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n*(n+1)/2];
            arr[0] = n;
            int cnt = 1;
            int begin =0;
            for (int i = n-1; i > 0 ; i--) {
                arr[cnt++] = i;
                for (int j = 0; j < i; j++) {
                    arr[cnt++] = arr[begin++];
                }
            }
            for (int i = n*(n+1)/2-1; i > n*(n+1)/2-n; i--) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[n*(n+1)/2-n]);
        }
    }
}
