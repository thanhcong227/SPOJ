import java.util.*;

public class AdaAndFriends {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        long friend = sc.nextLong();
        long unfriend = sc.nextLong();
        if (friend > 0 && unfriend > 0) {
            for (int i = 0; i < friend; i++) {
                String key = sc.next();
                long value = sc.nextLong();
                if (map.containsKey(key)) {
                    value += map.get(key);
                }
                map.put(key, value);
            }
        }

        Set<Map.Entry<String, Long>> entrySet = map.entrySet();
        List<Map.Entry<String, Long>> list = new ArrayList<>(entrySet);

        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        long sum = 0;
        if (list.size() > unfriend) {
            for (int i = list.size() - 1; i >= list.size() - unfriend; i--) {
                sum += list.get(i).getValue();
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i).getValue();
            }
        }
        System.out.println(sum);
    }
}
