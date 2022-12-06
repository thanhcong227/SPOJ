import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StopCity {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    static int[] vis1, vis2, vk;
    static Stack<Integer> stack;
    static int[] pot;
    static int[][] v;
    static int[] cnt;
    static int V;

    public static void bfs(int x, int b, int zaf) {
        Deque<Integer> qi = new LinkedList<>();
        qi.push(x);
        pot[x] = -1;
        vis2[x] = zaf;
        LinkedList<Integer> pat = new LinkedList<>();
        while (!qi.isEmpty()) {
            int topi = qi.poll();
            if (vis1[topi] == b && topi != x) {
                int y = topi;
                while (y != x) {
                    pat.add(y);
                    vis1[pot[y]] = b;
                    y = pot[y];
                }
                break;
            }
            for (int i = 0; i < cnt[topi]; i++) {
                if (vis2[v[topi][i]] != zaf && (vis1[v[topi][i]] != b || vis1[topi] != b)) {
                    vis2[v[topi][i]] = zaf;
                    qi.push(v[topi][i]);
                    pot[v[topi][i]] = topi;
                }
            }
        }
        for (Integer integer : pat) {
            stack.push(integer);
        }
    }

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        V = sc.nextInt();
        int a, b;
        vk = new int[V];
        cnt = new int[V];
        v = new int[V][V];
        vis1 = new int[V];
        vis2 = new int[V];
        pot = new int[V];
        stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            cnt[i] = 0;
        }
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == -1 && b == -1) {
                break;
            }
            if (a == b) {
                continue;
            }
            v[a][cnt[a]++] = b;
            v[b][cnt[b]++] = a;
        }
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();
        vis1[y] = 1;
        stack.push(x);
        int bro = 0;
        while (!stack.isEmpty()) {
            bro++;
            int g = stack.peek();
            stack.pop();
            bfs(g, 1, bro);
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis1[i] == 1) {
                vk[count] = i;
                count++;
            }
        }
        Arrays.sort(vk, 0, count);
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                out.write((" ").getBytes());
            }
            out.write((vk[i] + "").getBytes());
        }
        out.flush();
    }
}