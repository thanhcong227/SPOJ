import java.io.*;

public class ArrangingAmplifiers {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int k, l, j ,i;
        String[] b;
        long[] a;
        long temp;
        for (int u = 0; u < n; u++) {
            StringBuilder sb = new StringBuilder();
            k = Integer.parseInt(br.readLine());
            b = br.readLine().split("\\s");
            a = new long[k];
            for (int m = 0; m < b.length; m++) {
                a[m] = Long.parseLong(b[m]);
            }
            for (j = 0; j < b.length; j++) {
                for (i = 0; i < b.length-1 ; i++) {
                    if (a[i] >= a[i + 1]) {
                        temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                    }
                }
            }
            l = a.length - 2;
            for (j = 0; j < a.length && a[j] == 1; j++) {
                sb.append(a[j]+" ");
            }
            if (k > 1) {
                if (a[l] == 2 && a[l + 1] == 3) {
                    sb.append("2 3 ");
                    for (j = a.length - 3; j >= 0 && a[j] != 1; j--) {
                        if (a[j]==1) {
                            break;
                        }
                        sb.append(a[j]).append(" ");
                    }
                } else {
                    for (j = a.length - 1; j >= 0 && a[j] != 1; j--) {
                        if (a[j]==1) {
                            break;
                        }
                        sb.append(a[j] + " ");
                    }
                }
            } else {
                sb.append(a[0]+"\n");
            }
            System.out.println(sb);
        }
    }
}


