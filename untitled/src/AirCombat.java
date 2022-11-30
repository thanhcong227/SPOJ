import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AirCombat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int k = 0; k < n; k++) {
            int[] arr = new int[6];
            int[] local;
            String m = br.readLine();
            for (int i = 0; i < 6; i++) {
                arr[i] = Integer.parseInt(m.split(" ")[i]);
            }
            int object = 0;
            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                String line = br.readLine();
                String[] temp = line.split(" ");
                local = new int[3];
                for (int j = 0; j < 3; j++) {
                    local[j] = Integer.parseInt(temp[j + 1]);
                }
                if (line.charAt(0) == 'U') {
                    int r = Integer.parseInt(temp[4]);
                    for (int j = 0; j < 3; j++) {
                        arr[j] = local[j] - r;
                        arr[j + 3] = local[j] + r;
                    }
                    object = 1-object;
                } else if (line.charAt(0) == 'Q') {
                    int cnt = 0;
                    int newOject = object;
                    for (int j = 0; j < 3; j++) {
                        if (local[j] >= arr[j] && local[j] <= arr[j + 3]) {
                            cnt++;
                        }
                    }
                    if (cnt != 3) {
                        newOject = 1-newOject;
                    }
                    bo.write((newOject + "\n").getBytes());
                }
            }
        }
        bo.flush();
    }

}
