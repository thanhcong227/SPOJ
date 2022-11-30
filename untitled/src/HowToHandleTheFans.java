import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HowToHandleTheFans {

    static int[] a = new int[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        int MAX = n;
        while (q-->0) {
            String[] temp = br.readLine().split(" ");
            String string = temp[0];
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);
            if (string.charAt(0) == 'f') {
                bo.write((query(a,y)-query(a,x-1)+"\n").getBytes());
            } else {
                update(a, x, y);
            }
        }
        bo.flush();
    }

    public static void update(int[] a,int i, int val) {
        while (i < a.length) {
            a[i] += val;
            i += (i & -i);
        }
    }

    public static int query(int[] a, int index) {
        int sum = 0;
        while (index > 0) {
            sum += a[index];
            index -= (index & -index);
        }
        return sum;
    }
}