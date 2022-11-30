import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocialNetworkCommunity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        String[] line1 = br.readLine().split("\\s");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split("\\s");
            switch (line[0]) {
                case "A":
                    Union(Integer.parseInt(line[1]),Integer.parseInt(line[2]),parent,size,m);
                    break;
                case "E":
                    if (Find(Integer.parseInt(line[1]), parent) == Find(Integer.parseInt(line[2]), parent))
                        bo.write(("Yes\n").getBytes());
                    else
                        bo.write(("No\n").getBytes());
                    break;
                case "S":
                    int root = Find(Integer.parseInt(line[1]), parent);
                    bo.write((size[root] + "\n").getBytes());
            }
        }
        bo.flush();
    }

    public static void Union(int a, int b, int[] parent, int[] size,int m) {
        a = Find(a, parent);
        b = Find(b, parent);
        if (a == b || size[a] + size[b] > m) {
            return;
        }
        if (size[a] < size[b]) {
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }
    }


    public static int Find(int v, int[] parent) {
        while (v != parent[v]) {
            v = parent[v];
        }
        return v;
    }
}