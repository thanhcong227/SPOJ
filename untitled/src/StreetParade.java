import java.util.Scanner;

public class StreetParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            int st_size = 0;
            int start = 1;
            boolean check = true;
            for (int i = 0; i < n; i++) {
                while (st_size > 0 && arr2[st_size - 1] == start) {
                    st_size--;
                    start++;
                }
                if (arr1[i] == start)
                    start++;
                else if (st_size > 0 && arr2[st_size - 1] < arr1[i]) {
                    check = false;
                    break;
                } else {
                    arr2[st_size] = arr1[i];
                    st_size++;
                }
            }
            if (check)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

