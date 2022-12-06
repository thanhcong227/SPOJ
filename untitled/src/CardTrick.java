import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class CardTrick {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                bos.write(("1\n").getBytes());
            } else {
                int[] tree = new int[4 * n + 1];
                int[] arr = new int[n];
                build(0, n - 1, 1, tree);
                update(0, n - 1, 1, tree, 1,1);
                arr[1] = 1;
                int last = 1;
                for (int i = 2; i <= n; i++) {
                    int lb = query(0, n - 1, 1, tree, last + 1, n - 1);
                    int rb = query(0, n - 1, 1, tree, 0, last - 1);
                    int rank = i%(lb + rb);
                    if (rank < lb) {
                        int index = bin(last + 1, n - 1, last + 1, tree, n, rank + 1);
                        arr[index] = i;
                        update(0, n - 1, 1, tree, index,index);
                        last = index;
                    } else {
                        rank -= lb;
                        int index = bin(0, last - 1, 0, tree, n, rank + 1);
                        arr[index] = i;
                        update(0, n - 1, 1, tree, index,index);
                        last = index;
                    }
                }
                for (int i = 0; i < n; i++) {
                    bos.write((arr[i] + " ").getBytes());
                }
                bos.write(("\n").getBytes());
            }
        }
        bos.flush();
    }

    public static void build(int left, int right, int index, int[] tree) {
        if (left == right) {
            tree[index] = 1;
            return;
        }
        int mid = (left + right) / 2;
        build(left, mid, 2 * index, tree);
        build(mid + 1, right, 2 * index + 1, tree);
        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }


    public static int query(int left, int right, int index, int[] tree, int ql, int qr) {
        if (ql > right || qr < left || left > right)
            return 0;

        else if (ql <= left && qr >= right)
            return tree[index];

        int mid = (left + right) / 2;
        return query(left, mid, 2 * index, tree, ql, qr) + query(mid + 1, right, 2 * index + 1, tree, ql, qr);
    }

    public static void update(int left, int right, int index, int[] tree, int ql,int qr) {
        if (ql > right || qr < left || left > right) {
        } else if (left == right) {
            tree[index] = 0;
        } else {
            int mid = (right + left) / 2;
            update(left, mid, 2 * index, tree, ql, qr);
            update(mid + 1, right, 2 * index + 1, tree, ql, qr);
            tree[index] = tree[2 * index] + tree[2 * index + 1];
        }
    }

    public static int bin(int left, int right, int start, int[] tree, int n, int key) {
        if (left == right) {
            return left;
        } else if (right - left == 1) {
            int nb = query(0, n - 1, 1, tree, start, left);
            if (nb >= key) {
                return left;
            } else {
                return right;
            }
        } else {
            int mid = (left + right) / 2;
            int nb = query(0, n - 1, 1, tree, start, mid);
            if (nb >= key) {
                return bin(left, mid, start, tree, n, key);
            } else {
                return bin(mid + 1, right, start, tree, n, key);
            }
        }
    }

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
}
