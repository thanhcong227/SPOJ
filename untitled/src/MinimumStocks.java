import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class MinimumStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bo = new BufferedOutputStream(System.out);
        TreeMap<String, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("\\s");
            if (line[0].equals("3")) {
                int min = Integer.MAX_VALUE;
                String minString = "";
                for (String a : map.keySet()) {
                    if (map.get(a) < min) {
                        minString = a;
                        min = map.get(a);
                    }
                }
                bo.write((minString + " " + (i + 1) + "\n").getBytes());
                map.remove(minString);
            } else if (line[0].equals("1") || line[0].equals("2")) {
                map.put(line[1], Integer.valueOf(line[2]));
            }
        }
        bo.flush();
    }
}

