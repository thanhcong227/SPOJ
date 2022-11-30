import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class RunningMedianAgain {
    public static void main(String[] pp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ArrayList<Long> arrayList = new ArrayList();
            while (n > 0) {
                long k = Long.parseLong(br.readLine());
                if (k>0) {
                    arrayList.add(k);
                } else if (k==-1) {
                    Collections.sort(arrayList);
                    long h;
                    if (arrayList.size() % 2 == 1) {
                        h = arrayList.get(arrayList.size() / 2);
                        arrayList.remove(arrayList.get(arrayList.size() / 2));
                    } else {
                        h = arrayList.get(arrayList.size() / 2 - 1);
                        arrayList.remove(arrayList.get(arrayList.size() / 2 - 1));
                    }
                    bo.write((h+"\n").getBytes());
                } else {
                    break;
                }
            }
        }
        bo.flush();
    }
}