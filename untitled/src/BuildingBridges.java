import java.io.*;
import java.util.Arrays;

public class BuildingBridges {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }

    public static int lis(int[][] edge,int N, int[] lis) {
        Arrays.sort(edge, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            lis[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (edge[j][1] <= edge[i][1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[][] edge = new int[n][2];
            int[] lis = new int[n];
            for (int i = 0; i < n; i++) {
                edge[i][0] = s.nextInt();
            }
            for (int i = 0; i < n; i++) {
                edge[i][1] = s.nextInt();
            }
            out.write((lis(edge, n, lis) + "\n").getBytes());
        }
        out.flush();
    }
}