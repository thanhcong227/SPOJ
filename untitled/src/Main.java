import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        int[] north, south, temp;
        int a,temp1, temp2;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t <1)
                break;
            north = new int[t];
            south = new int[t];
            temp = new int[t];
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            for (int j = 0; j < t; j++) {
                north[j] = Integer.parseInt(line1[j]);
                south[j] = Integer.parseInt(line2[j]);
            }
            for (int j = 0; j < t - 1; j++) {
                for (int k = j + 1; k < t; k++) {
                    if (south[j] > south[k]) {
                        temp1 = south[j];
                        south[j] = south[k];
                        south[k] = temp1;
                        temp2 = north[j];
                        north[j] = north[k];
                        north[k] = temp2;
                    }
                }
            }
            int max = temp[0];
            for (int j = 1; j < t; j++) {
                int cnt = 0;
                for (int k = 0; k < j; k++) {
                    if (north[k] < north[j]) {
                        cnt++;
                    }
                }
                temp[j] = cnt;
                if (temp[j] > max) {
                    max = temp[j];
                }
            }
            bo.write((max + 1 + "\n").getBytes());
        }
        bo.flush();
    }

}