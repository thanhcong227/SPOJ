import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardTrick {
    public static void main(String[] args) throws IOException {
        int[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            int cnt = 1, cur = 0, left = n;
            while (cnt <= n) {
                int k = 0, j = cnt % left;
                while (k < j) {
                    if (arr[cur] == 0) {
                        k++;
                    }
                    cur = (cur + 1) % n;
                }
                while (arr[cur] != 0) {
                    cur = (cur + 1) % n;
                }
                arr[cur] = cnt++;
                left--;
            }
            for (int j = 0; j < n; j++) {
                bo.write((arr[j] + " ").getBytes());
            }
            bo.write(("\n").getBytes());
        }
        bo.flush();
    }
}
