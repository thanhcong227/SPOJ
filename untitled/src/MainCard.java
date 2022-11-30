import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainCard {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        int e;
        int tmp;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            arr[0] = n;
            int cnt = 1;
            for (int j = n - 1; j > 0; j--) {
                arr[n-j] = j;
                cnt++;
                tmp = j;
                while (tmp-->0){
                    e = arr[0];
                    for (int i = 0; i < cnt-1; i++) {
                        arr[i] = arr[i+1];
                    }
                    arr[cnt-1] = e;
                }
            }
            for (int i = n-1; i >=0; i--) {
                bos.write((arr[i] + " ").getBytes());
            }
            bos.write(("\n").getBytes());
        }
        bos.flush();
    }
}
