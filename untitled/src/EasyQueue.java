import java.io.*;

public class EasyQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        int n = Integer.parseInt(br.readLine());
        int h = -1;
        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String k = br.readLine();
            if (k.charAt(0) == '1') {
                arr[++h] = Integer.parseInt(k.substring(2));
            } else if (k.charAt(0) == '2') {
                if (count<=h) {
                    count++;
                }
            } else if (k.charAt(0) == '3') {
                bo.write((count > h ? "Empty!\n" : arr[count] + "\n").getBytes());
            }
        }
        bo.flush();
    }
}


