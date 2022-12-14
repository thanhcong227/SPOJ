import java.io.*;

public class Main {
    static int[][][] space;
    static int X, Y, Z;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int scenarios = Integer.parseInt(br.readLine());
        while (scenarios-- > 0) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int z1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int y2 = Integer.parseInt(line[4]);
            int z2 = Integer.parseInt(line[5]);
            X = x2 - x1 + 1;
            Y = y2 - y1 + 1;
            Z = z2 - z1 + 1;
            space = new int[X + 1][Y + 1][Z + 1];
            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                line = br.readLine().split(" ");
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                int z = Integer.parseInt(line[3]);
                if (line[0].equals("U")) {
                    int r = Integer.parseInt(line[4]);
                    update(x - x1, y - y1, z - z1, r);
                } else {
                    if (space[x - x1][y - y1][z - z1] == 1)
                        bos.write("Friend\n".getBytes());
                    else
                        bos.write("Enemy\n".getBytes());
                }
                bos.flush();
            }
        }
        bos.flush();
    }

    public static void update(int x, int y, int z, int r) {
        int xa = Math.max(1, x - r);
        int xb = x + r + 1;
        int ya = Math.max(1, y - r);
        int yb = y + r + 1;
        int za = Math.max(1, z - r);
        int zb = z + r + 1;
        space[xa][ya][za]++;
        space[xa][ya][zb]--;
        space[xa][yb][za]--;
        space[xa][yb][zb]++;
        space[xb][ya][za]--;
        space[xb][ya][zb]++;
        space[xb][yb][za]++;
        space[xb][yb][zb]--;

    }
}
//    public static void update(int x, int y, int z) {
//        for (int i = x; i <= X; i = i + (i & -i))
//            for (int j = y; j <= Y; j = j + (j & -j))
//                for (int k = z; k <= Z; k = k + (k & -k))
//                    space[i][j][k] = 1 - space[i][j][k];
//    }
//    public static boolean get(int x, int y, int z) {
//        int res = 0;
//        for (int i = x; i > 0; i = i - (i & -i))
//            for (int j = y; j > 0; j = j - (j & -j))
//                for (int k = z; k > 0; k = k - (k & -k))
//                    res += space[i][j][k];
//        return res != 0;
//}

