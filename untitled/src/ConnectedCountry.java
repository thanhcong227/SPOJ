import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectedCountry {

    public static void DFS(int node, int arr[][], boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                DFS(i, arr, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            String line = br.readLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int m = Integer.parseInt(line.split(" ")[1]);
            int[][] arr = new int[m][2];
            boolean[] blArr = new boolean[n];
            for (int i = 0; i < n; i++) {
                blArr[i] = false;
            }
            for (int i = 0; i < m; i++) {
                line = br.readLine();
                arr[i][0] = Integer.parseInt(line.split(" ")[0]);
                arr[i][1] = Integer.parseInt(line.split(" ")[1]);
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!blArr[i]) {
                    DFS(i, arr, blArr);
                    cnt++;
                }
            }
            bos.write((cnt + "").getBytes());
        }
        bos.flush();
    }
}
