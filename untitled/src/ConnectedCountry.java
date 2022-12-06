import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectedCountry {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        String[] line = br.readLine().split(" ");
        int cities, roads;
        cities = Integer.parseInt(line[0]);
        roads = Integer.parseInt(line[1]);
        int[] parent = new int[cities + 1];
        int[] size = new int[cities + 1];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < roads; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int r1 = findRoot(parent, a);
            int r2 = findRoot(parent, b);
            if (r1 == r2)
                continue;
            else {
                if (size[r1] >= size[r2]) {
                    parent[r2] = r1;
                    size[r1] += size[r2];
                } else {
                    parent[r1] = r2;
                    size[r2] += size[r1];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i)
                count++;
        }
        bos.write((count-1 + "\n").getBytes());
        bos.flush();
    }

    public static int findRoot(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }
}
