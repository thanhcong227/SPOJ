import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABugIsLife {

    static int[] father = new int[2005];
    static int[] relation = new int[2005];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bo.write(("Scenario #" + (i + 1) + ":\n").getBytes());
            int flag = 0;
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            for (int j = 0; j < n; j++) {
                father[j] = j;
                relation[j] = 1;
            }
            // 3 3
            // 1 2
            // 2 3
            // 1 3
            for (int j = 0; j < m; j++) {
                String[] line2 = br.readLine().split(" ");
                int a = Integer.parseInt(line2[0]);
                int b = Integer.parseInt(line2[1]);
                if (find_father(a)==find_father(b)) {
                    if (relation[a]==relation[b]) {
                        flag = 1;
                    }
                } else {
                    merge(a, b);
                }
            }
            if (flag==0) {
                bo.write(("No suspicious bugs found!\n").getBytes());
            } else {
                bo.write(("Suspicious bugs found!\n").getBytes());
            }
        }
        bo.flush();
    }

    public static int find_father(int i) {
        int t;
        if (father[i] == i) {
            return i;
        }
        t = father[i];
        father[i] = find_father(father[i]);
        relation[i] = (relation[i] + relation[t] + 1) % 2;
        return father[i];
    }

    public static void merge(int a, int b) {
        int x,y;
        x = find_father(a);
        y = find_father(b);
        father[x] = y;
        relation[x] = (relation[a] - relation[b]) % 2;
    }
}
