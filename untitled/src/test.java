import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        map.put(3, 4);
        for (int k : map.keySet()) {
            System.out.println(k);
        }
    }
}
